package U9Entregable2021;

import java.io.Serializable;
import java.util.Objects;

public class Libro implements Serializable {
    private String titulo, autor, editor, pais;
    private Integer paginas;

    public Libro(String titulo, String autor, String editor, Integer paginas, String pais) {
        this.titulo = titulo;
        this.autor = autor;
        this.editor = editor;
        this.paginas = paginas;
        this.pais = pais;
    }

    public Libro() {
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editor='" + editor + '\'' +
                ", paginas=" + paginas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return getTitulo().equals(libro.getTitulo()) && getAutor().equals(libro.getAutor()) && getEditor().equals(libro.getEditor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getAutor(), getEditor());
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
}
