package id.com.service.mh.scheduler;

import id.com.service.mh.utils.SQLQueryReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@EnableAsync
@RequiredArgsConstructor
@Slf4j
public class UpdateDataTrxScheduler {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SQLQueryReader sqlQueryReader;

    @Value("${sql.update.trx.path}")
    private String updateTrxSQLPath;

    @Scheduled(cron = "0 59 23 * * ?") // Every day at 23:59:00
    @Transactional
    public void scheduledUpdateTransactionDescriptions() {
        log.info("Starting scheduled transaction update at: {}", LocalDateTime.now());

        try {
            // Read the SQL query from file
            String updateQuery = sqlQueryReader.readQueryFromFile(updateTrxSQLPath);

            log.info("Executing scheduled update query...");

            // Execute the update
            int updatedRows = jdbcTemplate.update(updateQuery);

            log.info("Scheduled update completed successfully. Rows updated: {}", updatedRows);

        } catch (Exception e) {
            log.error("Error executing scheduled transaction update at {}: {}",
                    LocalDateTime.now(), e.getMessage(), e);
        }
    }

}
