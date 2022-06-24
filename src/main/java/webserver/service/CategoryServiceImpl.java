package webserver.service;

import webserver.dao.CategoryDao;
import webserver.domain.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDao();
    @Override
    public List<Category> findAll(){
        /*Jedis jedis = JedisUtil.getJedis();
        Set<String> categorys = jedis.zrange("category",0,-1);
        List<Category> cs = null;
        if(categorys == null || categorys.size() == 0){
            System.out.println("从数据库查询...");
            cs = categoryDao.findAll();
            for(int i = 0; i < cs.size();i++){
                jedis.zadd("category",cs.get(i).getCid(),cs.get(i).getCname());
            }
        }else{
            System.out.println("从redis中查询...");
            cs = new ArrayList<Category>();
            for(String name : categorys){
                Category category = new Category();
                category.setCname(name);
                cs.add(category);
            }
        }*/
        return categoryDao.findAll();
    }
}
