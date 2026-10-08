package in.pwskills.nitin.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//at revision time if the code will not work then run indivisual command not all together

@Component
public class ApplicationRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		String url="http://localhost:9999/v1/api/student";
		
		Mono<Student> addStudent=WebClient.
				create(url).
				post().
				uri("/insert").
				body(Mono.just(new Student("Ind25","Rahul",2300.0)),Student.class).
				retrieve().
				bodyToMono(Student.class);
		System.out.println("******Student add is*******");
		addStudent.subscribe(System.out::println);
		
		System.out.println("**********************************************************************");
		
		Mono<Student> findStudent=WebClient.
				create(url).
				get().
				uri("/find/Ind21").
				retrieve().bodyToMono(Student.class);
		System.out.println("******Student for given id is *****");
		findStudent.subscribe(System.out::println);
		
		System.out.println("*********************************************************************");
		
		
		Flux<Student> findAllStudent=WebClient.
				create(url).
				get().
				uri("/findAll").
				retrieve().bodyToFlux(Student.class);
		System.out.println("******All Students are*****");
		findAllStudent.doOnNext(System.out::println);
		
		System.out.println("**********************************************************************");
		
		WebClient.create(url).delete().
				uri("/delete/Ind23").retrieve().bodyToMono(Void.class).subscribe();
		System.out.println("Student is removed for given id from database");
		
	}

}
