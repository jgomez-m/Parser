select tb.ip_address, tb.cuenta quantity from (
select date, ip_address, count(*) cuenta from ip_requests 
GROUP BY ip_address ORDER BY ip_address
) tb where tb.cuenta > 200;
