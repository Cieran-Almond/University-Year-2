DROP DATABASE IF EXISTS Camera;
CREATE DATABASE Camera;
USE Camera;

	#created camera table

CREATE TABLE Camera (
	camera_price double,
	camera_brand VarChar (50),
	camera_model VarChar (50),
	camera_name VarChar (50),
	camera_stock int,
	camera_megapixel int,
	lens_name varChar (50),
	memory_name varChar (50),
	manufacturer_name varChar (50),
	PRIMARY KEY (camera_model)
	);
	
	# added cameras to database
	
	INSERT INTO Camera VALUES (949.00, "Pentax", "B01HMHHOJI", "K-70 DSLR", 34, 24, lens_name, memory_name, manufacturer_name);
	INSERT INTO Camera VALUES (297.00, "Canon", "B01CU8JZPU", "EOS 1300D DSLR", 78, 15, lens_name, memory_name, manufacturer_name);
	INSERT INTO Camera VALUES (1017.93, "Pentax", "B00YX2QYPG", "K-3II DSLR", 152, 20, lens_name, memory_name, manufacturer_name);
	INSERT INTO Camera VALUES (550.00, "Canon", "B00T9OEYXM", "EOS 750D DSLR", 124, 24, lens_name, memory_name, manufacturer_name);
	INSERT INTO Camera VALUES (383.90, "Nikon", "B01KOADMG4", "D3400 DSLR", 112, 18, lens_name, memory_name, manufacturer_name);
	INSERT INTO Camera VALUES (279.99, "Nikon", "B01M3RFM2F", "D60 Digital DSLR", 32, 16, lens_name, memory_name, manufacturer_name);
	
	#created lens table 

CREATE TABLE Lens (
	lens_make VarChar (50),
	lens_size VarChar (50),
	lens_price double,
	lens_name VarChar (50) REFERENCES Camera(lens_name),
	PRIMARY KEY (lens_name)
	);
	
	# added lenses to database
	
	INSERT INTO Lens VALUES ("Canon", "75-300mm", 115.97, "EF III Lens");
	INSERT INTO Lens VALUES ("Canon", "50mm", 106.00, "IF-S IS STM Lens");
	INSERT INTO Lens VALUES ("Canon", "24mm", 134.00, "EF-S STM Lens");
	INSERT INTO Lens VALUES ("Nikon", "55-300mm", 216.99, "AF-S VR Lens");
	INSERT INTO Lens VALUES ("Nikon", "18-140mm", 259.00, "AF-S ED VR Lens");
	INSERT INTO Lens VALUES ("Nikon", "35mm", 159.00, "AF-S DX Lens");
	INSERT INTO Lens VALUES ("Pentax", "35mm", 118.49, "SMC AL Lens");
	INSERT INTO Lens VALUES ("Pentax", "50-200mm", 169.00, "SMC ED WR Lens");
	
	#created memory card table
	
CREATE TABLE Memory_card (
	memory_space int,
	memory_brand VarChar (50),
	memory_write_speed double,
	memory_read_speed double,
	memory_name VarChar (50) REFERENCES Camera(memory_name),
	PRIMARY KEY (memory_name)
	);
	
	# added memory cards to database
	
	INSERT INTO Memory_card VALUES (32, "SanDisk", 15, 80, "SanDisk Ultra 32 GB" );
	INSERT INTO Memory_card VALUES (64, "Lexar", 20, 95, "Lexar 64GB Professional" );
	INSERT INTO Memory_card VALUES (64, "Samsung", 20, 95, "Samsung 64GB Evo Plus" );
	INSERT INTO Memory_card VALUES (2, "Fujifilm", 2, 5, "Fujifilm 2GB SD Memory Card" );
	INSERT INTO Memory_card VALUES (32, "Integral", 10, 40, "Integral UltimaPro 32GB MicroSDHC" );
	INSERT INTO Memory_card VALUES (64, "Toshiba", 25, 90, "Toshiba Exceria M302 64GB Micro SD" );

	#created manufacturer table 

CREATE TABLE Manufacturer (
	manufacturer_address varChar (100),
	manufacturer_name varChar (50) REFERENCES Camera(manufacturer_name),
	manufacturer_phone double,
	manufacturer_registration int,
	manufacturer_website varChar (50),
	PRIMARY KEY (manufacturer_name)
	);
	
	# added manufacturers to database
	
	INSERT INTO Manufacturer VALUES ("3 The Square, Stockley Park, Uxbridge, Middlesex, United Kingdom, UB11 1ET", "Canon Europe Ltd", 442085888000, 23425, "www.canon-europe.com" );
	INSERT INTO Manufacturer VALUES ("380 Richmond Rd, Kingston upon Thames, KT2 5DB", "Nikon UK Ltd", 02085414440, 23561, "www.europe-nikon.com");
	INSERT INTO Manufacturer VALUES ("Customer Service, PO Box 81226, Seattle, WA, 98108-1226", "Amazon", 8882803321, 23678, "www.Amazon.com" );
	INSERT INTO Manufacturer VALUES ("1st Floor, 3 Furzeground Way, Stockley Park, Uxbridge, Middlesex, UB11 1EZ", "Toshiba", 03332227444, 58674, "www.toshiba.co.uk");
	INSERT INTO Manufacturer VALUES ("951 SanDisk Drive, Milpitas, CA 95035-7933", "Sandisk", 4088011000, 59492, "www.sandisk.co.uk");
	INSERT INTO Manufacturer VALUES ("Samsung Electronics (UK) Ltd, Samsung House 1000 Hillswood Drive Chertsey, Surrey KT16 0PS", "Samsung", 01932455000, 01858, "www.samsung.com");
	
	# query database
	
	#query 1
	
	SELECT camera_brand, camera_name, camera_stock, camera_megapixel, camera_model, camera_price
	FROM Camera
	WHERE camera_price > 400
	ORDER BY camera_name, camera_name DESC;
	
	#query 2
	
	SELECT manufacturer_name, manufacturer_address, manufacturer_phone, manufacturer_website
	FROM Manufacturer
	WHERE manufacturer_name LIKE '%Amazon%';
	
	#query 3
	
	SELECT Camera.camera_name, Camera.camera_model, Lens.lens_make, Lens.lens_size
	FROM Camera
	INNER JOIN Lens ON Camera.lens_name = Lens.lens_name
	WHERE Camera.lens_name LIKE "%Canon%";
	
	
	#query 4
	
	SELECT * 
	FROM Lens
	WHERE lens_price BETWEEN 10 AND 300;
	

	
	
	
	
	
	


	