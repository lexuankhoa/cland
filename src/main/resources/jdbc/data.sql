MERGE INTO roles (id, name) KEY (id) VALUES
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_EDITOR'),
    (3, 'ROLE_USER');

MERGE INTO users (id, username, fullname, password, enabled, role_id) KEY (id) VALUES
    (1, 'admin', 'Administrator', '$2a$10$kUInrWrj2pmCtTeasvmSU.KYA20fbglmbbrCKzTGWTNMp7BPxIw9a', TRUE, 1);

MERGE INTO categories (cid, cname) KEY (cid) VALUES
    (1, 'Căn hộ'),
    (2, 'Nhà đất'),
    (3, 'Đất nền');

MERGE INTO lands (lid, lname, description, picture, area, address, count_views, cid) KEY (lid) VALUES
    (1, 'Căn hộ trung tâm thành phố', 'Căn hộ tiện nghi, gần trường học và khu mua sắm.', '', 75, 'Đà Nẵng', 25, 1),
    (2, 'Nhà phố khu dân cư', 'Nhà phố có không gian thoáng, phù hợp cho gia đình.', '', 120, 'Hội An', 18, 2),
    (3, 'Đất nền ven biển', 'Lô đất có vị trí thuận lợi và pháp lý rõ ràng.', '', 150, 'Quảng Nam', 12, 3);
