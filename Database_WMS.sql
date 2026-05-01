-- =========================================
-- DATABASE : wms
-- =========================================

DROP DATABASE IF EXISTS wms;
CREATE DATABASE wms;
USE wms;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS barang;


-- =========================================
-- TABLE : user
-- =========================================
CREATE TABLE user (
username VARCHAR(50), 
password VARCHAR(50), 
role VARCHAR(50), 
full_name VARCHAR(50));

INSERT INTO user (username, password, role, full_name) 
VALUES 
('admin_hamada', 'hamada123', 'Admin Hamada', 'Razan'),
('staff_kausar', 'dapur456', 'Staff Kausar', 'Wijdan'),
('owner_boss', 'pantau789', 'Owner', 'Bapak Fauzi');


-- =========================================
-- TABLE : user
-- =========================================
CREATE TABLE barang (
id_barang VARCHAR(20),
nama_barang VARCHAR(50), 
kategori VARCHAR(50), 
jumlah INT);

INSERT INTO barang (nama_barang, kategori, jumlah) 
VALUES 
('Beras', 'Karbohidrat', 20),
('Telur', 'Protein', 40),
('Tempe', 'Protein', 30),
('Kentang', 'Karbohidrat', 20),
('Pisang', 'Karbohidrat', 25);

-- Isi id_barang otomatis
SET @counter = 0;
UPDATE barang 
SET id_barang = CONCAT('BRG', LPAD(@counter := @counter + 1, 3, '0'));

-- Jadikan PRIMARY KEY
ALTER TABLE barang 
MODIFY COLUMN id_barang VARCHAR(20) NOT NULL,
ADD PRIMARY KEY (id_barang);
