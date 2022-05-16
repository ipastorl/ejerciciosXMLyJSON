package U8.src.examen;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ProcessPosts pp = new ProcessPosts();
        Post post = new Post();

        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el títtulo del Post");
        post.setTitle(sc.nextLine());
        System.out.println("Indique el link del Post");
        post.setLink(sc.nextLine());
        System.out.println("Indique el descripción del Post");
        post.setDescription(sc.nextLine());
        System.out.println("Indique el fecha del Post");
        post.setPubdate(sc.nextLine());
        System.out.println("Indique el guid del Post");
        post.setGuid(sc.nextLine());


        pp.parseDOM("posts.xml");
        pp.addPost(post);

        pp.getPosts();
        pp.convertToJSON();
        System.out.println(pp.nomPostsStax("posts.xml"));

    }
}
