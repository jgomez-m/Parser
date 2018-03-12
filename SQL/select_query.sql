
-- (1) Write MySQL query to find IPs that mode more than a certain number of requests for a given time period.

select tb.ip_address, tb.cuenta quantity from (
select date, ip_address, count(*) cuenta from ip_requests 
GROUP BY ip_address ORDER BY ip_address
) tb where tb.cuenta > 200;

-- (2) Write MySQL query to find requests made by a given IP.
select * from wallethub.access_log
where ip = '192.168.102.136';
