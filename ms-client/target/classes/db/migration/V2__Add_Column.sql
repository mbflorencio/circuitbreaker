INSERT INTO client (name, description)
SELECT
    CONCAT('Cliente ', CAST(ROWNUM() AS VARCHAR)),
    CONCAT('Descrição do Cliente ', CAST(ROWNUM() AS VARCHAR))
FROM
    (SELECT 1 FROM SYSTEM_RANGE(1, 20))
ORDER BY RANDOM();