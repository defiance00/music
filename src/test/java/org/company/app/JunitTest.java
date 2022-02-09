package org.company.app;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.company.app.dao.MusicDAO;
import org.company.app.dto.Music;
import org.company.app.service.MusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//스프링 테스트(spring-test pom.xml에 라이브러리 추가)
//객체를 생성하기 위한 어노테이션 추가
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitTest {
	@Autowired
	private MusicDAO musicDAO;
//	@Autowired
//	private MusicService musicService;
	@Autowired
	private DataSource dataSource;
//	@Test
//	public void Test() throws Exception {
//		musicService.json_insert(null, null);
//	}
	@Test 
	public void testdataSource() throws SQLException {
		dataSource.getConnection();
	}
	@Test
	public void TestMusicInsert()  {
		Music music = new Music();
		music.setArtistname("Megadeth");	
		
		
	
		
		music.setGenres("thrash metal");
		music.setOrigin("Los Angeles, California, U.S.");
		music.setYearsactive("1983–2002, 2004–present");
		musicDAO.insert(music);
	}
}