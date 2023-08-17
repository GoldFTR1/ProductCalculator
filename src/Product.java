
public class Product {
	
	double UnitCost;
	double markup;
	double UnitPrice;
	double ProductPromotion;
	
	Product(double UnitCost, double markup,double ProductPromotion,double UnitPrice){
		this.UnitCost=UnitCost;
		this.markup=markup;
		this.ProductPromotion=ProductPromotion;
		this.UnitPrice=UnitPrice;
		
	}
	Product(){
		this.UnitCost=0;
		this.markup=0;
		this.UnitCost=0;
	}
	
	
	static double MarkUpCalculator(double UnitCost, double markup, double ProductPromotion) {
		
		double BasePrice= UnitCost+(UnitCost*markup/100);
		double FinalPrice = BasePrice -(BasePrice*ProductPromotion/100);
		return FinalPrice;
	}
	static double PromotionCalculator(double UnitCost, double markup, double ProductPromotion) {
		double BasePrice= UnitCost+(UnitCost*markup/100);
		double FinalPrice = (BasePrice*ProductPromotion/100);
		return FinalPrice;
	}
	
	static double MarkUpCalculatorC(double UnitCost, double markup){
		double BasePrice = UnitCost+markup;
		//double FinalPrice = BasePrice -(BasePrice*ProductPromotion/100);
		return BasePrice;
		
	}
	//Not implemented, was used in earlier version but it's redundant as we already know the base unit price
	static double BaseUnitPrice(double UnitCost, double markup) {
		double BasePrice= UnitCost+(UnitCost*markup/100);
		
		return BasePrice;
	}
	
	public double getUnitCost() {
		return UnitCost;
	}
	public void setUnitCost(double unitCost) {
		UnitCost = unitCost;
	}
	public double getMarkup() {
		return markup;
	}
	public void setMarkup(double markup) {
		this.markup = markup;
	}
	public double getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}
	public double getProductPromotion() {
		return ProductPromotion;
	}
	public void setProductPromotion(double productPromotion) {
		ProductPromotion = productPromotion;
	}
	
}
