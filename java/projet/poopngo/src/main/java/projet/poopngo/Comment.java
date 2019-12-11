package projet.poopngo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity

public class Comment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private Long id_source;
    
    private Long id_target;
    
    private String text;
    public String getName_target() {
		return name_target;
	}

	public void setName_target(String name_target) {
		this.name_target = name_target;
	}

	private String name_target;

	public Long getId_source() {
		return id_source;
	}

	public void setId_source(Long id_source) {
		this.id_source = id_source;
	}

	public Long getId_target() {
		return id_target;
	}

	public void setId_target(Long id_target) {
		this.id_target = id_target;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Comment(Long id_source, Long id_target, String text) {
		super();
		this.id_source = id_source;
		this.id_target = id_target;
		this.text = text;
	}

    public Comment() {
	}
}


