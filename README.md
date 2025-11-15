# OnlineShoppingSystem

**Tech Stack:** Java Servlets, JSP, MySQL

This is a minimal, ready-to-run Java web project that demonstrates:

- User registration & login (simple session)
- Product catalog listing
- Add-to-cart (session-based)
- Checkout (creates orders)
- Admin dashboard (simple product management)

## How to run (Eclipse + Tomcat)

1. Install Java (JDK 11+), Eclipse (Enterprise), and Apache Tomcat 10.
2. Import this folder as a "Dynamic Web Project" or create a new Dynamic Web Project and copy the files.
3. Add the MySQL JDBC driver (mysql-connector-java) to the project's `WEB-INF/lib`.
4. Create a MySQL database and import `shopping.sql`.
5. Update DB credentials in `src/com/shop/utils/DBConnection.java`.
6. Run on Tomcat from Eclipse.

## Files included

- `src/` : Java source (servlets, DAOs, models, utils)
- `WebContent/` : JSP pages, CSS, images
- `WebContent/WEB-INF/web.xml`
- `shopping.sql` : SQL to create tables and sample data
- `README.md` : this file


