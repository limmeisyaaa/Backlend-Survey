--Data Customer that heir spouse (female) also did loan transaction
--If spouse female have nominal credit >= their spouse (male) with in interval 30Days
--then update status in female table transaction in desc column with 'Please re-review this transaction'

WITH transactions_to_update AS (
    SELECT
        male_t.trx_id,
        CONCAT('Please re-review transaction Mr. ', male_mc.full_name,
               ' because nominal credit <= Ms ', sd.spouse_name) as new_description
    FROM "transaction" male_t
    JOIN mst_customer male_mc ON male_mc.customer_id = male_t.customer_id
    JOIN survey s ON male_t.trx_id = s.trx_id
    JOIN spouse_data sd ON sd.spouse_id = s.spouse_id
    JOIN mst_customer female_mc ON sd.spouse_nik = female_mc.nik
    JOIN "transaction" female_t ON female_mc.customer_id = female_t.customer_id
    WHERE male_t.trx_status = 'ON_PROCESS'
    AND male_mc.gender = 'MALE'
    AND female_mc.gender = 'FEMALE'
    AND female_t.trx_date BETWEEN male_t.trx_date - INTERVAL '30 days' AND male_t.trx_date
    AND female_t.nominal_credit >= male_t.nominal_credit
)

UPDATE "transaction"
SET description = ttu.new_description
FROM transactions_to_update ttu
WHERE "transaction".trx_id = ttu.trx_id;