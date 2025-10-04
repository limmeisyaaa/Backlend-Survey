package id.com.service.mh.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Component
@Slf4j
public class SQLQueryReader {

    private final ConcurrentHashMap<String, String> queryCache = new ConcurrentHashMap<>();

    public String readQueryFromFile(String filePath) throws IOException {
        return queryCache.computeIfAbsent(filePath, key -> {
            try {
                ClassPathResource resource = new ClassPathResource(filePath);
                if (!resource.exists()) {
                    throw new IOException("SQL file not found: " + filePath);
                }

                try (InputStreamReader reader = new InputStreamReader(
                        resource.getInputStream(), StandardCharsets.UTF_8)) {
                    String query = FileCopyUtils.copyToString(reader);
                    log.info("Successfully loaded SQL query from: {}", filePath);

                    // Remove SQL comments and extract the main query
                    String cleanedQuery = query.replaceAll("--.*", "")
                            .replaceAll("/\\*.*?\\*/", "")
                            .trim();

                    return cleanedQuery;
                }
            } catch (IOException e) {
                log.error("Failed to read SQL file: {}", filePath, e);
                throw new RuntimeException("Failed to read SQL file: " + filePath, e);
            }
        });
    }

    public void clearCache() {
        queryCache.clear();
        log.info("SQL query cache cleared");
    }
}