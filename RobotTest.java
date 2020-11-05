import java.util.Random;
import java.util.Scanner;
import java.io.*;
 abstract class Robot 
 {
	protected float M_trong_luong;
	protected float S_quang_duong;
	protected float Energy;
	protected String Name;
	protected abstract float CalculateEnergy() ;
	public void  setS(float S)
	{
		this.S_quang_duong=S;
	}	
 }
class Pedion extends Robot{
	float F_linh_hoat;
	public void  setM()
	{
		this.M_trong_luong=20;
	}
	public void SetName()
	{
		this.Name="Pedion";
	}
	public void  setF()
	{
		Random generator = new Random();
		this.F_linh_hoat= generator.nextInt(4) + 1;
	}
    public float CalculateEnergy()
    {
        
    	return M_trong_luong * S_quang_duong +(F_linh_hoat+1)*S_quang_duong/2;
    }
    
}
class Zattacker extends Robot{
	float P_suc_manh;
	public void  setM()
	{
		this.M_trong_luong=50;
	}	
	
	public void  setP()
	{
		Random generator = new Random();
		this.P_suc_manh= generator.nextInt(10) + 20;
		//this.P_suc_manh=25;
	}
	public void SetName()
	{
		this.Name="Zattacker";
	}
	public float CalculateEnergy()
    {
    	
    	return M_trong_luong * S_quang_duong +P_suc_manh*P_suc_manh*S_quang_duong;
    }
}
class Carrier extends Robot{
	float E_van_chuyen;
	public void  setM()
	{
		this.M_trong_luong=30;
	}
	public void  setE()
	{
		Random generator = new Random();
		this.E_van_chuyen= generator.nextInt(50) + 50;
		//this.E_van_chuyen=60;
	}
	public void SetName()
	{
		this.Name="Carrier";
	}
    public float CalculateEnergy()
    {
    	return M_trong_luong * S_quang_duong +4*E_van_chuyen*S_quang_duong;
    }
}

public class RobotTest {

	public static void main(String[] args)
	{
		 int NumOfPedion,NumOfCarrier,NumOfZattacker;
		 float TotalEnergy=0,TotalCarrierEnergy=0,TotalPedionEnergy=0,TotalZattackerEnergy=0;
		 float MaxEnergyPedion=0,MaxEnergyCarrier=0,MaxEnergyZattacker=0;
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Nhap vao so robot Pedion : ");
		 NumOfPedion=sc.nextInt();
		 System.out.print("Nhap vao so robot Carrier : ");
		 NumOfCarrier=sc.nextInt();
		 System.out.print("Nhap vao so robot Zattacker : ");
		 NumOfZattacker=sc.nextInt();
		 Pedion[] PedionList =new Pedion[NumOfPedion];
		 Carrier[] CarrierList =new Carrier[NumOfCarrier];
		 Zattacker[] ZattackerList =new Zattacker[NumOfZattacker];
		 for(int i=0;i<NumOfPedion;i++)
		 {
			 PedionList[i]=new Pedion();
			 PedionList[i].SetName();
			 PedionList[i].setF();
			 PedionList[i].setS(10);
			 PedionList[i].setM();
			 PedionList[i].Energy=PedionList[i].CalculateEnergy();
			 System.out.println("Thong tin Robot Pedion "+ i +" :");
			 System.out.println("Loai : "+ PedionList[i].Name);
			 System.out.println("Khoi luong : "+ PedionList[i].M_trong_luong);
			 System.out.println("Do linh hoat : "+ PedionList[i].F_linh_hoat);
			 System.out.println("Nang luong : "+ PedionList[i].Energy);
			 if(PedionList[i].Energy>MaxEnergyPedion)
			 {
				 MaxEnergyPedion=PedionList[i].Energy;
			 }
			 
			 TotalPedionEnergy+=PedionList[i].Energy;
		 }
		
		 for(int i=0;i<NumOfCarrier;i++)
		 {
			 CarrierList[i]=new Carrier();
			 CarrierList[i].SetName();
			 CarrierList[i].setE();
			 CarrierList[i].setS(10);
			 CarrierList[i].setM();
			 CarrierList[i].Energy=CarrierList[i].CalculateEnergy();
			 System.out.println("Thong tin Robot Pedion "+ i +" :");
			 System.out.println("Loai : "+ CarrierList[i].Name);
			 System.out.println("Khoi luong : "+ CarrierList[i].M_trong_luong);
			 System.out.println("Nang luong tiep te : "+ CarrierList[i].E_van_chuyen);
			 System.out.println("Nang luong : "+ CarrierList[i].Energy);
			 if(CarrierList[i].Energy>MaxEnergyCarrier)
			 {
				 MaxEnergyCarrier=CarrierList[i].Energy;
			 }
			 
			 TotalCarrierEnergy+=CarrierList[i].Energy;
		 }
		 
		 for(int i=0;i<NumOfZattacker;i++)
		 {
			 ZattackerList[i]=new Zattacker();
			 ZattackerList[i].SetName();
			 ZattackerList[i].setP();
			 ZattackerList[i].setS(10);
			 ZattackerList[i].setM();
			 ZattackerList[i].Energy=ZattackerList[i].CalculateEnergy();
			 System.out.println("Thong tin Robot Pedion "+ i +" :");
			 System.out.println("Loai : "+ ZattackerList[i].Name);
			 System.out.println("Khoi luong : "+ ZattackerList[i].M_trong_luong);
			 System.out.println("Suc manh : "+ ZattackerList[i].P_suc_manh);
			 System.out.println("Nang luong : "+ ZattackerList[i].Energy);
			 if(ZattackerList[i].Energy>MaxEnergyZattacker)
			 {
				 MaxEnergyZattacker=ZattackerList[i].Energy;
			 }
			 TotalZattackerEnergy+=ZattackerList[i].Energy;
		 
		 }
		 if(MaxEnergyZattacker>MaxEnergyPedion &&MaxEnergyZattacker>MaxEnergyCarrier)
			 System.out.println("Loai Robot co nang luong nhieu nhat : Zattscker");
		 if(MaxEnergyZattacker==MaxEnergyPedion &&MaxEnergyZattacker==MaxEnergyCarrier)
			 System.out.println("Loai Robot co nang luong nhieu nhat :Pedion,Carrier,Zattscker,");
		 if(MaxEnergyPedion>MaxEnergyZattacker &&MaxEnergyPedion>MaxEnergyCarrier)
			 System.out.println("Loai Robot co nang luong nhieu nhat : Pedion");
		 if(MaxEnergyCarrier>MaxEnergyZattacker &&MaxEnergyCarrier>MaxEnergyPedion)
			 System.out.println("Loai Robot co nang luong nhieu nhat : Carrier");
		 if(MaxEnergyZattacker==MaxEnergyPedion &&MaxEnergyZattacker>MaxEnergyCarrier)
			 System.out.println("Loai Robot co nang luong nhieu nhat : Zattscker,Pedion");
		 if(MaxEnergyPedion==MaxEnergyZattacker &&MaxEnergyPedion>MaxEnergyCarrier)
			 System.out.println("Loai Robot co nang luong nhieu nhat : Pedion,Zattacker");
		 if(MaxEnergyCarrier==MaxEnergyZattacker &&MaxEnergyCarrier>MaxEnergyPedion)
			 System.out.println("Loai Robot co nang luong nhieu nhat : Carrier,Zattacker");
		 TotalEnergy=TotalCarrierEnergy+TotalPedionEnergy+TotalZattackerEnergy;
		 System.out.println("Tong nang luong da tieu thu cua ca doan Robot : "+TotalEnergy);
	}

}
