SET @max = 0;

SELECT @max := count(MEMBER_ID)
FROM REST_REVIEW
GROUP BY MEMBER_ID
ORDER BY count(MEMBER_ID) desc
LIMIT 1;


SELECT b.MEMBER_NAME, a.REVIEW_TEXT, DATE_FORMAT(a.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
FROM REST_REVIEW as a
JOIN MEMBER_PROFILE as b ON a.MEMBER_ID = b.MEMBER_ID
where a.MEMBER_ID IN (SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    HAVING count(MEMBER_ID) = @max
    ORDER BY count(MEMBER_ID) desc)
ORDER BY a.REVIEW_DATE, a.REVIEW_TEXT;

