package com.example.zavodliva;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.zavodliva.entity.Artist;
import com.example.zavodliva.entity.Show;
import com.example.zavodliva.entity.Song;
import com.example.zavodliva.repository.ArtistRepository;
import com.example.zavodliva.repository.ShowRepository;
import com.example.zavodliva.repository.SongRepository;
import com.example.zavodliva.user.entity.Role;
import com.example.zavodliva.user.entity.RoleName;
import com.example.zavodliva.user.entity.RoleRepository;
import com.example.zavodliva.user.entity.UserRepository;

@SpringBootApplication
public class ZavodlivaKvecherinaApplication {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	SongRepository songRepository;
	
	@Autowired
	ArtistRepository artistRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ZavodlivaKvecherinaApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		try {
			
			roleRepository.save(new Role(1L, RoleName.ROLE_ADMIN));
			
			artistRepository.save(new Artist(1, "Anatu" , "/img/anatu.jpg"));
			artistRepository.save(new Artist(2, "Andra" , "/img/andra.jpg"));
			artistRepository.save(new Artist(3, "Calum Scott" , "/img/calumscott.jpg"));
			artistRepository.save(new Artist(4, "David Bisbal" , "/img/david-bisbal.jpg"));
			artistRepository.save(new Artist(5, "Doja Cat" , "/img/Doja_Cat.jpg"));
			artistRepository.save(new Artist(6, "Irina Rimes" , "/img/irina-rimas.jpg"));
			artistRepository.save(new Artist(7, "Jason Mraz" , "/img/jasonmraz.jpg"));
			artistRepository.save(new Artist(8, "Leona Lewis" , "/img/leonalewis.jpg"));
			artistRepository.save(new Artist(9, "Sean Kingston" , "/img/sean-kingston.jpg"));
			artistRepository.save(new Artist(10, "Victor Biliac" , "/img/victor-biliac.jpg"));
			artistRepository.save(new Artist(11, "Zubi" , "/img/zubi.jpg"));
			artistRepository.save(new Artist(12, "Marcela Mangabeira" , "/img/marcela-mangabeira.webp"));
			artistRepository.save(new Artist(13, "Tahta Menezes" , "/img/tahta-menezes.jpg"));
			artistRepository.save(new Artist(14, "Cecelia Dale" , "/img/cecelia-dale.jpg"));
			artistRepository.save(new Artist(15, "Monique Kessous" , "/img/moni-kess.jpg"));
			artistRepository.save(new Artist(16, "Cliff Richard" , "/img/clif-rich.webp"));
			artistRepository.save(new Artist(17, "Manuel Carrasco" , "/img/manuel-carasco.jpg"));
			artistRepository.save(new Artist(18, "Sergey Grischuk" , "/img/artist.jpg"));
			artistRepository.save(new Artist(19, "Houssem Amari" , "/img/hous-amari.jpg"));
			artistRepository.save(new Artist(20, "Amelie Martinez" , "/img/amelie.jpg"));
			artistRepository.save(new Artist(21, "Andy Williams" , "/img/andy-williams.jpg"));
			artistRepository.save(new Artist(22, "Kygo" , "/img/kygo.jpg"));
			artistRepository.save(new Artist(23, "Miguel" , "/img/miguel.png"));
			artistRepository.save(new Artist(24, "Alberto Vazquez" , "/img/alb-vaz.jpg"));
			artistRepository.save(new Artist(25, "Matteo Bocelli" , "/img/mateo.jpg"));
			artistRepository.save(new Artist(26, "Eve St. Jones" , "/img/eve.jpg"));
			artistRepository.save(new Artist(27, "Dim Zach" , "/img/dim-zach.jpg"));
			artistRepository.save(new Artist(28, "Lila Liu" , "/img/lila-liu.jpg"));
			/*
			artistRepository.save(new Artist(29, "Russio Lorro" , "/img/artist.jpg"));
			artistRepository.save(new Artist(30, "Karen Souza" , "/img/karensouza.jpg"));
			artistRepository.save(new Artist(31, "DHARIA" , "/img/DHARIA.jpg"));
			artistRepository.save(new Artist(32, "Ermal Meta" , "/img/ErmalMeta.jpg"));
			artistRepository.save(new Artist(33, "Elisa" , "/img/Elisa.jpg"));
			artistRepository.save(new Artist(34, "Amir Haddad" , "/img/AmirHaddad.jpg"));
			artistRepository.save(new Artist(35, "Morandi" , "/img/morandi.jpg"));
			artistRepository.save(new Artist(36, "Caro Emerald" , "/img/CaroEmerald.jpg"));
			artistRepository.save(new Artist(37, "Nieggman" , "/img/Nieggman.jpg"));
			*/
			artistRepository.save(new Artist(29, "Shakatak" , "/img/shakatak.jpg"));
			artistRepository.save(new Artist(30, "Ash" , "/img/ash.jpg"));
			artistRepository.save(new Artist(31, "Adele" , "/img/adele.png"));
			artistRepository.save(new Artist(32, "Sting" , "/img/sting.jpg"));
			artistRepository.save(new Artist(33, "Eric Clapton" , "/img/clapton.png"));
			artistRepository.save(new Artist(34, "Vanotek" , "/img/Vanotek.jpg"));
			artistRepository.save(new Artist(35, "Denitia" , "/img/denitia.jpg"));
			artistRepository.save(new Artist(36, "The Frajle" , "/img/frajle.jpg"));
			artistRepository.save(new Artist(37, "Tijana" , "/img/tijana.jpg"));
			artistRepository.save(new Artist(38, "Nicki Parrott" , "/img/parrot.jpg"));
			artistRepository.save(new Artist(39, "MikeAndTess" , "/img/mikeandtess.jpg"));
			
			
			List<Artist> woman = new ArrayList<>();
			woman.add(artistRepository.findById(5).get());
			
			songRepository.save(new Song(1, "Woman", "2021", woman));
			
			List<Artist> reason = new ArrayList<>();
			reason.add(artistRepository.findById(3).get());
			reason.add(artistRepository.findById(8).get());
			
			songRepository.save(new Song(2, "You Are The Reason (Duet Version)", "2018", reason));
			
			List<Artist> luna = new ArrayList<>();
			luna.add(artistRepository.findById(7).get());
			
			songRepository.save(new Song(3, "Bella Luna", "2005", luna));
			
			List<Artist> girls = new ArrayList<>();
			girls.add(artistRepository.findById(9).get());
			
			songRepository.save(new Song(4, "Beautiful Girls", "2007", girls));
			
			List<Artist> victor = new ArrayList<>();
			victor.add(artistRepository.findById(10).get());
			
			songRepository.save(new Song(5, "Un Amore Grande", "2021", victor));
			
			List<Artist> irina = new ArrayList<>();
			irina.add(artistRepository.findById(6).get());
			
			songRepository.save(new Song(6, "Bolnavi Amandoi", "2017", irina));
			
			List<Artist> andra = new ArrayList<>();
			andra.add(artistRepository.findById(2).get());
			andra.add(artistRepository.findById(4).get());
			
			songRepository.save(new Song(7, "Without You", "2016", andra));
			
			List<Artist> zubi = new ArrayList<>();
			zubi.add(artistRepository.findById(1).get());
			zubi.add(artistRepository.findById(11).get());
			
			songRepository.save(new Song(8, "Sugar", "2021", zubi));
			
            List<Song> penkalo = new ArrayList<>();
            penkalo.add(songRepository.findById(1).get());
            penkalo.add(songRepository.findById(2).get());
            penkalo.add(songRepository.findById(3).get());
            penkalo.add(songRepository.findById(4).get());
            penkalo.add(songRepository.findById(5).get());
            penkalo.add(songRepository.findById(6).get());
            penkalo.add(songRepository.findById(7).get());
            penkalo.add(songRepository.findById(8).get());
			
			showRepository.save(new Show(1,"Човекот од пенкала", "/img/penkalo.jpg" , "/audios/chovekodpenkala.mp3", LocalDate.of(2022, 01, 12), penkalo));
			
			List<Artist> marcela = new ArrayList<>();
			marcela.add(artistRepository.findById(12).get());
			
			songRepository.save(new Song(9, "All I Want For Christmas Is You", "2006", marcela));
			
			List<Artist> tahta = new ArrayList<>();
			tahta.add(artistRepository.findById(13).get());
			
			songRepository.save(new Song(10, "Happy Christmas (War Is Over)", "2006", tahta));
			
			List<Artist> dale = new ArrayList<>();
			dale.add(artistRepository.findById(14).get());
			
			songRepository.save(new Song(11, "Jingle Bells", "2005", dale));
			
			List<Artist> moniq = new ArrayList<>();
			moniq.add(artistRepository.findById(15).get());
			
			songRepository.save(new Song(12, "Last Christmas", "2006", moniq));
			
			List<Artist> cliff = new ArrayList<>();
			cliff.add(artistRepository.findById(16).get());
			
			songRepository.save(new Song(13, "Mistletoe and Wine", "1988", cliff));
			
			List<Artist> manuel = new ArrayList<>();
			manuel.add(artistRepository.findById(17).get());
			
			songRepository.save(new Song(14, "Llegó Navidad", "2020", manuel));
			
			List<Artist> dale2 = new ArrayList<>();
			dale2.add(artistRepository.findById(14).get());
			
			songRepository.save(new Song(15, "Let It Snow! Let It Snow! Let It Snow!", "2005", dale2));
			
			List<Song> praznicna = new ArrayList<>();
			praznicna.add(songRepository.findById(9).get());
			praznicna.add(songRepository.findById(10).get());
			praznicna.add(songRepository.findById(11).get());
			praznicna.add(songRepository.findById(12).get());
			praznicna.add(songRepository.findById(13).get());
			praznicna.add(songRepository.findById(14).get());
			praznicna.add(songRepository.findById(15).get());
			
			showRepository.save(new Show(2,"Денот пред или потоа", "/img/ludata.jfif" , "/audios/praznicna.mp3", LocalDate.of(2021, 12, 29), praznicna));
			
			
			List<Artist> sergey = new ArrayList<>();
			sergey.add(artistRepository.findById(18).get());
			
			songRepository.save(new Song(16, "Rain...Rain ( Instrumental)", "2021", sergey));
			
			List<Artist> eve = new ArrayList<>();
			eve.add(artistRepository.findById(26).get());
			
			songRepository.save(new Song(17, "Everywhere", "2020", eve));
			
			List<Artist> porti = new ArrayList<>();
			porti.add(artistRepository.findById(19).get());
			porti.add(artistRepository.findById(20).get());
			
			songRepository.save(new Song(18, "Por Ti", "2020", porti));
			
			List<Artist> love = new ArrayList<>();
			love.add(artistRepository.findById(28).get());
			love.add(artistRepository.findById(29).get());
			
			songRepository.save(new Song(19, "Lost In Love", "2021", love));
			
			List<Artist> kisses = new ArrayList<>();
			kisses.add(artistRepository.findById(24).get());
			
			songRepository.save(new Song(20, "Save Your Kisses For Me", "2017", kisses));
			
			List<Artist> solo = new ArrayList<>();
			solo.add(artistRepository.findById(25).get());
			
			songRepository.save(new Song(21, "Solo", "2021", solo));
			
			List<Artist> andi = new ArrayList<>();
			andi.add(artistRepository.findById(21).get());
			andi.add(artistRepository.findById(27).get());
			
			songRepository.save(new Song(22, "Love Story (Dim Zach Disco Mix)", "2017", andi));
			
			List<Artist> remind = new ArrayList<>();
			remind.add(artistRepository.findById(22).get());
			remind.add(artistRepository.findById(23).get());
			
			songRepository.save(new Song(23, "Remind Me to Forget", "2017", remind));
			
			List<Song> prva22 = new ArrayList<>();
			prva22.add(songRepository.findById(16).get());
			prva22.add(songRepository.findById(17).get());
			prva22.add(songRepository.findById(18).get());
			prva22.add(songRepository.findById(19).get());
			prva22.add(songRepository.findById(20).get());
			prva22.add(songRepository.findById(21).get());
			prva22.add(songRepository.findById(22).get());
			prva22.add(songRepository.findById(23).get());
			
			showRepository.save(new Show(3,"Балон од желби", "/img/baloon.jpg" , "/audios/balon.mp3", LocalDate.of(2022, 01, 14), prva22));
			
			/*
			List<Artist> rain = new ArrayList<>();
			rain.add(artistRepository.findById(29).get());
			
			songRepository.save(new Song(24, "Rain...Rain ( Instrumental)", "2016", rain));
			
			
			List<Artist> seen = new ArrayList<>();
			seen.add(artistRepository.findById(30).get());
			
			songRepository.save(new Song(25, "Have You Ever Seen The Rain?", "2011", seen));
			
			List<Artist> sugar = new ArrayList<>();
			sugar.add(artistRepository.findById(31).get());
			
			songRepository.save(new Song(26, " Sugar & Brownies", "2018", sugar));
			
			List<Artist> piccola = new ArrayList<>();
			piccola.add(artistRepository.findById(32).get());
			piccola.add(artistRepository.findById(33).get());
			
			songRepository.save(new Song(27, "Piccola Anima", "2017", piccola));
			
			List<Artist> retine = new ArrayList<>();
			retine.add(artistRepository.findById(34).get());
			
			songRepository.save(new Song(28, "Rétine", "2020", retine));
			
			List<Artist> train = new ArrayList<>();
			train.add(artistRepository.findById(35).get());
			
			songRepository.save(new Song(29, "Midnight Train", "2011", train));
			
			List<Artist> back = new ArrayList<>();
			back.add(artistRepository.findById(36).get());
			
			songRepository.save(new Song(30, "Back It Up", "2010", back));
			
			List<Artist> sultan = new ArrayList<>();
			sultan.add(artistRepository.findById(37).get());
			
			songRepository.save(new Song(31, "Sultans of Swing", "2017", sultan));
			
			List<Song> trains = new ArrayList<>();
			trains.add(songRepository.findById(24).get());
			trains.add(songRepository.findById(25).get());
			trains.add(songRepository.findById(26).get());
			trains.add(songRepository.findById(27).get());
			trains.add(songRepository.findById(28).get());
			trains.add(songRepository.findById(29).get());
			trains.add(songRepository.findById(30).get());
			trains.add(songRepository.findById(31).get());
			
			showRepository.save(new Show(5,"Полноќен воз", "/img/train.jpg" , "/audios/train.mp3", LocalDate.of(2022, 01, 21), trains));
			*/
			List<Artist> birds = new ArrayList<>();
			birds.add(artistRepository.findById(29).get());
			
			songRepository.save(new Song(24, "Night Birds", "2019", birds));
			 
			List<Artist> ash = new ArrayList<>();
			ash.add(artistRepository.findById(30).get());
			ash.add(artistRepository.findById(20).get());
			
			songRepository.save(new Song(25, "Dans La Peau", "2019", ash));
			
			List<Artist> adele = new ArrayList<>();
			adele.add(artistRepository.findById(31).get());
			
			songRepository.save(new Song(26, "Million Years Ago", "2015", adele));
			
			List<Artist> mikeandtess = new ArrayList<>();
			mikeandtess.add(artistRepository.findById(32).get());
			mikeandtess.add(artistRepository.findById(33).get());
			mikeandtess.add(artistRepository.findById(39).get());
			
			songRepository.save(new Song(27, "It's Probably Me (Mikeandtess Boot Edit)", "2014", mikeandtess));
			
			List<Artist> someone  = new ArrayList<>();
			someone.add(artistRepository.findById(34).get());
			someone.add(artistRepository.findById(35).get());
			
			songRepository.save(new Song(28, "Someone", "2021", someone));
			
			List<Artist> frajle  = new ArrayList<>();
			frajle.add(artistRepository.findById(36).get());
			frajle.add(artistRepository.findById(37).get());
			
			songRepository.save(new Song(29, "ZIVOTE KRENI", "2015", frajle));
			
			List<Artist> parrot = new ArrayList<>();
			parrot.add(artistRepository.findById(38).get());
			
			songRepository.save(new Song(30, "Will Wait For You", "2013", parrot));
			
			List<Song> prikaznata = new ArrayList<>();
			prikaznata.add(songRepository.findById(24).get());
			prikaznata.add(songRepository.findById(25).get());
			prikaznata.add(songRepository.findById(26).get());
			prikaznata.add(songRepository.findById(27).get());
			prikaznata.add(songRepository.findById(28).get());
			prikaznata.add(songRepository.findById(29).get());
			prikaznata.add(songRepository.findById(30).get());
			
			showRepository.save(new Show(4,"Приказната која ја чекам", "/img/prikaznata.jpg" ,"/audios/prikaznata.mp3", LocalDate.of(2022, 01, 21), prikaznata));
			
		} catch (Exception e) {
			System.out.println("Post construct NOT called");
	}
		
	}
}
