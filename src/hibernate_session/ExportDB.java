package hibernate_session;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {

	public static void main(String[] args) {
		
//		读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration().configure();
		
//		
		SchemaExport export = new SchemaExport(cfg);
		
//		将源码生成DDL		
		export.create(true, true);
	}

}
