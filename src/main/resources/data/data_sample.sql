-- ==============================================================
-- SCRIPT NẠP DỮ LIỆU MẪU CHO ỨNG DỤNG BÁN HÀNG (SALEAPP)
-- Cơ sở dữ liệu: WebBanHang (MySQL / MariaDB trên Laragon)
-- ==============================================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- 1. XÓA DỮ LIỆU CŨ NẾU CẦN RESET (BỎ COMMENT NẾU MUỐN XÓA SẠCH ĐỂ TẠO LẠI)
-- TRUNCATE TABLE products;
-- TRUNCATE TABLE categories;

-- 2. THÊM 6 DANH MỤC SẢN PHẨM PHONG PHÚ
INSERT INTO categories (id, name) VALUES
(1, 'Điện Thoại & Tablet'),
(2, 'Laptop & Máy Tính'),
(3, 'Màn Hình Máy Tính'),
(4, 'Bàn Phím & Chuột'),
(5, 'Tai Nghe & Âm Thanh'),
(6, 'Linh Kiện & Phụ Kiện')
ON DUPLICATE KEY UPDATE name = VALUES(name);

-- 3. THÊM 18 SẢN PHẨM CÔNG NGHỆ CAO CẤP LIÊN KẾT VỚI DANH MỤC
INSERT INTO products (id, name, price, description, image, category_id) VALUES
-- === Danh mục 1: Điện Thoại & Tablet ===
(1, 'iPhone 15 Pro Max 256GB Titan Tự Nhiên', 29490000, 
 'Thiết kế khung viền Titan siêu nhẹ và bền bỉ, màn hình Super Retina XDR 120Hz, chip Apple A17 Pro mạnh mẽ, camera zoom quang 5x đỉnh cao.', 
 'https://images.unsplash.com/photo-1695048133142-1a20484d2569?w=600&auto=format&fit=crop&q=80', 1),

(2, 'Samsung Galaxy S24 Ultra 5G 12GB/256GB', 27990000, 
 'Quyền năng Galaxy AI đỉnh cao, khung viền Titan, màn hình phẳng Dynamic AMOLED 2X sắc nét, tích hợp bút S-Pen và camera 200MP zoom 100x.', 
 'https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=600&auto=format&fit=crop&q=80', 1),

(3, 'iPad Pro 11 inch M4 256GB Wi-Fi', 26990000, 
 'Thiết kế mỏng kỷ lục thế giới chỉ 5.3mm, chip Apple M4 thế hệ mới với hiệu năng AI vượt trội, màn hình Ultra Retina XDR OLED kép tuyệt đẹp.', 
 'https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=600&auto=format&fit=crop&q=80', 1),

-- === Danh mục 2: Laptop & Máy Tính ===
(4, 'MacBook Pro 14 M3 Pro (18GB / 512GB)', 45990000, 
 'Màu Space Black cực chất, màn hình Liquid Retina XDR 120Hz ProMotion, thời lượng pin ấn tượng lên tới 18 giờ, sức mạnh render đồ họa tuyệt đỉnh.', 
 'https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=600&auto=format&fit=crop&q=80', 2),

(5, 'Laptop ASUS ROG Zephyrus G16 OLED', 48990000, 
 'Laptop Gaming cao cấp vỏ nhôm CNC mỏng nhẹ, CPU Intel Core Ultra 9, card đồ họa NVIDIA RTX 4070 8GB, màn hình OLED 2.5K 240Hz chuẩn màu.', 
 'https://images.unsplash.com/photo-1588872657578-7efd1f1555ed?w=600&auto=format&fit=crop&q=80', 2),

(6, 'Dell XPS 15 9530 Core i7 / RTX 4050', 42500000, 
 'Đỉnh cao laptop doanh nhân và sáng tạo, vỏ nhôm nguyên khối phối sợi carbon, màn hình 3.5K OLED cảm ứng tràn viền InfinityEdge đẳng cấp.', 
 'https://images.unsplash.com/photo-1593642632823-8f785ba67e45?w=600&auto=format&fit=crop&q=80', 2),

-- === Danh mục 3: Màn Hình Máy Tính ===
(7, 'Màn hình Gaming LG UltraGear 27 inch 165Hz', 4890000, 
 'Độ phân giải 2K QHD (2560x1440), tấm nền Fast IPS 1ms, hỗ trợ công nghệ G-Sync Compatible và HDR10 mang lại hình ảnh mượt mà tuyệt đối.', 
 'https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=600&auto=format&fit=crop&q=80', 3),

(8, 'Màn hình Đồ Họa Dell UltraSharp U2724D 2K', 9990000, 
 'Công nghệ IPS Black cho tỷ lệ tương phản 2000:1, chuẩn màu chuyên nghiệp 100% sRGB, kết nối Thunderbolt 4 và cảm biến tự động chỉnh sáng.', 
 'https://images.unsplash.com/photo-1547119957-637f8679db1e?w=600&auto=format&fit=crop&q=80', 3),

(9, 'Màn hình Cong Samsung Odyssey G7 32 inch 240Hz', 11500000, 
 'Độ cong 1000R hoàn hảo góc nhìn, độ phân giải 2K WQHD, tần số quét 240Hz siêu tốc, công nghệ QLED tái tạo dải màu sắc rực rỡ và sống động.', 
 'https://images.unsplash.com/photo-1550745165-9bc0b252726f?w=600&auto=format&fit=crop&q=80', 3),

-- === Danh mục 4: Bàn Phím & Chuột ===
(10, 'Bàn Phím Cơ Custom MonsGeek M1W V3 SP', 2150000, 
 'Khung nhôm CNC Anodized cao cấp, hỗ trợ 3 chế độ kết nối (Type-C, 2.4G, Bluetooth), mạch xuôi Hotswap, pin 6000mAh, trải nghiệm gõ phím cực êm.', 
 'https://images.unsplash.com/photo-1587829741301-dc798b83add3?w=600&auto=format&fit=crop&q=80', 4),

(11, 'Bàn Phím Logitech MX Keys Mini Không Dây', 1890000, 
 'Thiết kế công thái học mỏng gọn, phím lõm theo ngón tay gõ cực êm, cảm biến tự động bật đèn nền khi tay đến gần, sạc nhanh qua cổng USB-C.', 
 'https://images.unsplash.com/photo-1595225476474-87563907a212?w=600&auto=format&fit=crop&q=80', 4),

(12, 'Chuột Không Dây Logitech MX Master 3S', 1990000, 
 'Biểu tượng của hiệu suất làm việc văn phòng, con lăn điện từ MagSpeed cuộn 1000 dòng/giây, cảm biến 8000 DPI lướt mượt trên mọi bề mặt kể cả mặt kính.', 
 'https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?w=600&auto=format&fit=crop&q=80', 4),

(13, 'Chuột Gaming Siêu Nhẹ Razer Viper V3 Pro', 3590000, 
 'Trọng lượng siêu nhẹ chỉ 54g chuẩn thi đấu Esports, cảm biến quang học Focus Pro 35K Gen-2, tần số phản hồi không dây HyperPolling 8000Hz.', 
 'https://images.unsplash.com/photo-1605773527852-c546a8584ea3?w=600&auto=format&fit=crop&q=80', 4),

-- === Danh mục 5: Tai Nghe & Âm Thanh ===
(14, 'Tai Nghe Chống Ồn Cao Cấp Sony WH-1000XM5', 6490000, 
 'Công nghệ chống ồn chủ động ANC hàng đầu thế giới với bộ xử lý V1 và QN1, hỗ trợ codec LDAC âm thanh Hi-Res Audio, thời lượng pin 30 giờ liên tục.', 
 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=600&auto=format&fit=crop&q=80', 5),

(15, 'Tai Nghe True Wireless Apple AirPods Pro 2 Type-C', 5390000, 
 'Trang bị chip Apple H2 mang đến âm thanh thông minh hơn, chống ồn chủ động gấp đôi, âm thanh không gian cá nhân hóa Spatial Audio sống động.', 
 'https://images.unsplash.com/photo-1600294037681-c80b4cb5b434?w=600&auto=format&fit=crop&q=80', 5),

(16, 'Loa Bluetooth Di Động Marshall Stanmore III', 7990000, 
 'Thiết kế phong cách cổ điển Iconic Vintage, âm trường rộng đa hướng lan tỏa khắp căn phòng, kết nối Bluetooth 5.2 và cổng cắm AUX 3.5mm tiện dụng.', 
 'https://images.unsplash.com/photo-1545454675-3531b543be5d?w=600&auto=format&fit=crop&q=80', 5),

-- === Danh mục 6: Linh Kiện & Phụ Kiện ===
(17, 'Củ Sạc Nhanh Anker Prime 67W GaN 3 Cổng', 890000, 
 'Công nghệ bán dẫn GaNPrime siêu nhỏ gọn và mát mẻ, công suất 67W sạc nhanh cùng lúc cho Laptop, Tablet và Smartphone thông qua 2 cổng USB-C và 1 USB-A.', 
 'https://images.unsplash.com/photo-1622445262464-84b14e324513?w=600&auto=format&fit=crop&q=80', 6),

(18, 'Bàn Nâng Hạ Công Thái Học Dual Motor 1m4', 5800000, 
 'Động cơ kép nâng hạ êm ái tải trọng 120kg, mặt bàn gỗ MDF phủ Melamine chống trầy xước, bảng điều khiển cảm ứng nhớ 4 vị trí độ cao thông minh.', 
 'https://images.unsplash.com/photo-1518455027359-f3f8164ba6bd?w=600&auto=format&fit=crop&q=80', 6)

ON DUPLICATE KEY UPDATE 
    name = VALUES(name),
    price = VALUES(price),
    description = VALUES(description),
    image = VALUES(image),
    category_id = VALUES(category_id);

SET FOREIGN_KEY_CHECKS = 1;

-- ==============================================================
-- HOÀN TẤT NẠP DỮ LIỆU MẪU CHO WebBanHang!
-- ==============================================================
