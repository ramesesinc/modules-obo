DROP VIEW IF EXISTS vw_obo_professional;
CREATE VIEW vw_obo_professional  AS		
SELECT 
    p.*,
	pi.firstname,
	pi.middlename,
	pi.lastname,
	pi.birthdate,
	pi.gender,
	pi.resident,
	pi.address_objid,
	pi.address_text,
	pi.address_unitno,
	pi.address_bldgno,
	pi.address_bldgname,
	pi.address_street,
	pi.address_subdivision,
	pi.address_barangay_objid,
	pi.address_barangay_name,
	pi.address_citymunicipality,
	pi.address_province,
	pi.tin,
	pi.email,
	pi.mobileno,
	pi.phoneno,
	pi.id_idno,
	pi.id_type_name,
	pi.id_dtissued,
	pi.id_placeissued,
	pi.prc_dtissued,
	pi.prc_dtvalid,
	pi.prc_placeissued,
	pi.ptr_refno,
	pi.ptr_dtissued,
	pi.ptr_placeissued,

	id.caption AS id_type_caption,
	id.title AS id_type_title

FROM obo_professional p
INNER JOIN obo_professional_info pi ON p.infoid = pi.objid 
INNER JOIN idtype id ON pi.id_type_name = id.name;	
