package storeInv;

import java.io.Serializable;

class SKUkeeper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int tableSize = 100;
	int[] SKUdata;
	
	public SKUkeeper()
	{
		SKUdata = new int[tableSize];
		for(int i = 0; i < tableSize; i++)
		{
			SKUdata[i] = -1;
		}
	}
	
	public int hashValue(int SKU)
	{
		return SKU % tableSize;
	}
	
	public int linearProbing(int i,int SKU)
	{
	    int loc = hashValue(SKU);
	    int newLoc = (loc + (i*1)) % tableSize;
	    return newLoc;
	}
	
	public boolean SKUexists(int SKU)
	{
		int loc = hashValue(SKU);
		int i = 0;
		while(SKUdata[loc] != -1)
		{
			if(SKUdata[loc] == SKU)
			{
				return true;
			}
			else
			{
				loc = linearProbing(i, SKU);
				++i;
			}
		}
		return false;
    }
	
	public boolean storeSKU(int SKU)
	{
		int loc = hashValue(SKU);
		int i = 0;

		while(i <= tableSize)
		{
			if(SKUdata[loc] == -1)
			{
				SKUdata[loc] = SKU;
				return true;
			}
			else
			{
				loc = linearProbing(i, SKU);
				i++;
			}
		}
		return false;
	}
	
	public boolean delete(int SKU)
	{
		return false;
	}
}
