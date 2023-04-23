import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class excelReader {

	public static void main(String[] args) {
		
		String excelPath = "./test_data/TestDAta.xlsx";
		String query = "select * from Order_Jacket";
		
		Fillo fillo = new Fillo();
		Connection conn = fillo.getConnection(excelPath);
		Recordset recordSet = conn.executeQuery(query);
		while(recordSet.next()) {
			System.out.println(recordSet.getField("TC001"));
		}

	}

}
