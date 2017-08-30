package com.yc.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	/**
	 * 保存对象<br />
	 * @param t
	 *            :要保存的数据对象
	 * @param sqlId:
	 *            mapper中的方法名
	 *            "com.yc.bean."+ 类名 +"Mapper."+sqlId 
	 */
	public void save(T t, String sqlId);
	
	/**
	 * 保存对象<br />
	 * @param t :   确定mapper文件位置
	 * @param sqlId : 操作名
	 * @param parameterMap   : 参数值
	 */
	public void save(Class<T> t,String sqlId, Map<String,Object> parameterMap);
	
	/**
	 * 批量添加<br />
	 * mysql 代码:
	 * <insert id="addTag" parameterType="Tag" >
		insert into tag(tid,tname,tcount) values
		<foreach collection="list" open="" close="" separator="," item="item">
			(#{item.tid},#{item.tname},1)
		</foreach>
	</insert>
	 * @param clazz
	 * @param sqlId
	 * @param list
	 */
	void save(Class<T> clazz, String sqlId, List<T> list);

	/**
	 * 更新对象 <br />
	 * @param t:带有参数的待更新对象
	 * @param sqlId :mapper中的方法名
	 */
	public void update(T t, String sqlId);
	
	/**
	 * 根据条件更新
	 * @param t
	 * @param sqlId
	 * @param parameterMap   :  待更新的值
	 */
	public void update( Class<T> t, String sqlId, Map<String,Object> parameterMap);
	/**
	 * 一次性更新所有的值
	 * @param clazz
	 * @param sqlId
	 */
	void update(Class<T> clazz, String sqlId);

	/**
	 * 批量更新指定的行 <br />
	 * <!-- 批量处理:   将标签的数量加一,更新操作 -->
	<update id="increaseCount" parameterType="Tag">
		update tag set tcount=tcount+1
		where tid in
		<foreach collection="list" open="(" close=")" separator="," item="tag">
			#{tag.tid}
		</foreach>
	</update>
	 * @param clazz
	 * @param sqlId
	 * @param list
	 */
	void update(Class<T> clazz, String sqlId, List<T> list);

	/**
	 * 只根据id删除一条数据 <br />
	 * @param clazz : 对象的反射实例,用于确认  mapper文件的位置
	 * @param id :    要删除的数据的编号
	 * @param sqlId:  mapper中的方法名
	 */
	public void del(Class<T> clazz,  String sqlId, String id);
	/**
	 * 根据条件  parameterMap删除<br />
	 * @param clazz
	 * @param sqlId
	 * @param parameterMap
	 */
	public void del(Class<T> clazz,  String sqlId, Map<String,Object> parameterMap);
	
	/**
	 * 根据对象其它条件删除
	 * @param t
	 * @param sqlId
	 */
	public void del(T t,  String sqlId);
	
	/**
	 * 根据ids删除多条数据<br />
	 * @param clazz : 对象的反射实例,用于确认  mapper文件的位置
	 * @param ids :    要删除的数据的编号,它是一个集合，多个编号
	 * @param sqlId:  mapper中的方法名 
	 */
	public void del(Class<T> clazz,String sqlId, List<Object> ids );

	/**
	 * 查集合,  没有条件属性
	 * @param clazz   对象的反射实例,用于确认  mapper文件的位置
	 * @param sqlId    mapper中的方法名 
	 * @return  集合
	 */
	public List<T> findAll(Class<T> clazz, String sqlId);
	
	/**
	 * 查集合,  条件查询
	 * @param t   条件对象,用于确认  mapper文件的位置及条件值
	 * @param sqlId    mapper中的方法名 
	 * @return  集合
	 */
	public List<T> findAll(T t, String sqlId);
	
	public List<T> findAll( Class<T> clazz, String sqlId, Map<String,Object> parameterMap);

	public T findOne(Class<T> clazz,String sqlId);
	
	public T findOne(T t, String sqlId);
	
	public T findOne( Class<T> clazz, String sqlId, Map<String,Object> parameterMap);
	
	
	/**
	 * 聚合查询<br />
	 * @return
	 */
	public double getFunc(Class<T> clazz, String sqlId);
	
	/**
	 * 聚合查询<br />
	 * @param clazz   用于确认mapper文件位置
	 * @param sqlId     mapper里面的方法名
	 * @return
	 */
	public double getFunc(T t, String sqlId);
	
	public double getFunc( Class<T> clazz, String sqlId, Map<String,Object> parameterMap );


	
	

}