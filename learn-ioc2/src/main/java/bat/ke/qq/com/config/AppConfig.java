package bat.ke.qq.com.config;


import bat.ke.qq.com.core.MyImportBeanDefinitionRegistrar;
import bat.ke.qq.com.core.MyMapperScan;
import bat.ke.qq.com.dao.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 */

@Configuration
//@MapperScan("bat.ke.qq.com.dao")
@ComponentScan("bat.ke.qq.com")
//@MyMapperScan("bat.ke.qq.com.dao")
public class AppConfig {

	/**
	 * dataSource
	 * @return
	 */
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}


	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		return factoryBean.getObject();
	}

//	@Bean
//	public MapperFactoryBean<UserMapper> userMapper() throws Exception {
//		MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<>(UserMapper.class);
//		factoryBean.setSqlSessionFactory(sqlSessionFactory());
//		return factoryBean;
//	}





}
