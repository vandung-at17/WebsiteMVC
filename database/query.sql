select 
p.id as id_product
,p.id_category
,p.sizes
,p.name
,p.price
,p.sale
,p.title
,p.highlight
,p.new_product
,p.detail
,c.id as id_color
,c.name as name_color
,c.code as code_color
,c.img
,p.createddate
,p.modifieddate
from
products as p
inner join
colors as c
on p.id = c.id_product
group by p.id,c.id_product