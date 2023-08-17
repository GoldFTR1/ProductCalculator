
public class Client {
	
	int ClientId;
	double BasicDiscount;
	double Over10000Disc;
	double Over30000Disc;
	
	Client(int ClientId, double BasicDiscount, double Over10000Disc, double Over30000Disc){
		this.ClientId = ClientId;
		this.BasicDiscount = BasicDiscount;
		this.Over10000Disc = Over10000Disc;
		this.Over30000Disc = Over30000Disc;
		
		
	}
	Client(){
		this.ClientId=0;
		this.BasicDiscount=0;
		this.Over10000Disc=0;
		this.Over30000Disc=0;		
	}

}
