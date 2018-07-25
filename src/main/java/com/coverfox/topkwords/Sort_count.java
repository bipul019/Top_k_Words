package com.coverfox.topkwords;

import java.util.Comparator;

class Sort_count implements Comparator<Frequency>{

	public int compare(Frequency f,Frequency o) {
		if(f.getCount()>=o.getCount()){
			if(f.getCount()>o.getCount())
				return -1;
			else {
				if(f.getWord().compareTo(o.getWord())>0)
					return -1;
				else
					return 1;
			}
		}
		else
			return 1;
	}

	
	
}
