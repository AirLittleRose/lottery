package com.yc.soccer.utils;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public  class Combine<E> {

	private List<List<E>> largeList = new ArrayList<List<E>>();
      
    /** 
     * 步骤：：每次递归时，把原始数据和满足条件的工作空间复制一份，所有的操作均在复制文件中进行，目的就是保证不破坏原始数据， 
     *      从而可以让一轮递归结束后可以正常进行下一轮。 
     *      其次，把数据的第一个元素添加到工作空间中，判断工作空间的大小，如果小于k,则需要继续递归，但此时，传入递归函数的 
     *      参数需要注意：假设当前插入的节点的下标是i,因为是顺序插入的,所以i之前的所有数据都应该舍去，只传入i之后的未使用过的数据。 
     *      因此在传参之前，应该对copydata作以处理；当大于k的时候，则表明已经找到满足条件的第一种情况，然后只需修改该情况的最后一个结果即可。 
     *      如：找到abc时，则只需替换c为d即可完成该轮递归。 
     *  
     * @param data  原始数据 
     * @param workSpace 自定义一个临时空间，用来存储每次符合条件的值 
     * @param k     C(n,k)中的k 
     */  
    private void combinerSelect(List<E> data, List<E> workSpace, int n, int k) {  
        List<E> copyData;  
        List<E> copyWorkSpace;  
        
        if(workSpace.size() == k) {
        	List<E> smallList = new ArrayList<E>();
            for(Object c : workSpace) {
            	smallList.add((E) c);
//            	System.out.print(c);
            }
//            System.out.println();  
            largeList.add(smallList);
        }  
        
        for(int i = 0; i < data.size(); i++) {  
            copyData = new ArrayList<E>(data);  
            copyWorkSpace = new ArrayList<E>(workSpace);  
              
            copyWorkSpace.add(copyData.get(i));  
            for(int j = i; j >=  0; j--)  
                copyData.remove(j);  
            combinerSelect(copyData, copyWorkSpace, n, k);  
        }  
          
    }
    
    /**
     * 
     * @param data	所有的数据集合
     * @param k		从集合中选择的个数  即C(n,k)中的k
     * @return
     */
    public List<List<E>> toCombine(List<E> data, int k) {
    	try {
			List<E> workSpace = data.getClass().newInstance();
	    	this.combinerSelect(data, workSpace, data.size(), k);
	    	
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
    	return this.largeList;
    }
  
}
