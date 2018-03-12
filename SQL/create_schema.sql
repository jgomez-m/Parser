drop table IF exists ip_requests;

CREATE TABLE ip_requests(
	date VARCHAR(200),
	ip_address VARCHAR(200),
	request VARCHAR(200),
	status VARCHAR(200),
	user_agent VARCHAR(200)
);

select tb.ip_address, tb.cuenta quantity from (
select date, ip_address, count(*) cuenta from ip_requests 
GROUP BY ip_address ORDER BY ip_address
) tb where tb.cuenta > 200;

truncate table ip_requests;