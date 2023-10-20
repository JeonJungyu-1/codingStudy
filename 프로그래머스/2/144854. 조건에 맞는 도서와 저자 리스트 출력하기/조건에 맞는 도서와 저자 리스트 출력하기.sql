SELECT book_id, author_name, date_format(published_date, "%Y-%m-%d") as published_date
FROM BOOK as a
join author as b on a.author_id = b.author_id
where a.category = "경제"
order by published_date asc