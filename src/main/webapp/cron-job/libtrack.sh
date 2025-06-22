#!/bin/bash

DB_USER="root"
DB_PASSWORD="password"
DB_NAME="libtrack"


QUERY1="UPDATE book_transactions 
SET 
    status = 'overdue' 
WHERE 
    actual_return_date IS NULL AND CURDATE() > return_date 
    AND status != 'overdue';"


QUERY2="INSERT INTO defaulter (student_id, book_id, overdue_days, fine_amount, fine_status)
SELECT
    bt.student_id,
    bt.book_id,
    DATEDIFF(CURDATE(), bt.return_date) AS overdue_days,
    DATEDIFF(CURDATE(), bt.return_date) * 5 AS fine_amount,  
    'unpaid' AS fine_status
FROM
    book_transactions bt
WHERE
    bt.status = 'overdue'
    AND NOT EXISTS (
        SELECT 1 FROM defaulter d
        WHERE d.student_id = bt.student_id
          AND d.book_id = bt.book_id
    );"
    
    
QUERY3="UPDATE defaulter d
JOIN book_transactions bt ON d.student_id = bt.student_id AND d.book_id = bt.book_id
SET 
    d.overdue_days = DATEDIFF(CURDATE(), bt.return_date),
    d.fine_amount = DATEDIFF(CURDATE(), bt.return_date) * 5  
WHERE 
    bt.status = 'overdue'
    AND d.fine_status = 'unpaid';"

echo "Libtrack cron job ran at $(date)" >> $(dirname $0)/libtrack.log

mysql -u $DB_USER -p$DB_PASSWORD -D $DB_NAME -e "$QUERY1"

mysql -u $DB_USER -p$DB_PASSWORD -D $DB_NAME -e "$QUERY2"

mysql -u $DB_USER -p$DB_PASSWORD -D $DB_NAME -e "$QUERY3"

