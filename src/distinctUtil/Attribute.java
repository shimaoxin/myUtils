package distinctUtil;

public class Attribute {
    
    @ParentValue(name="id")
    @Unique
    private String id;
    
    @ParentValue(name="code")
    private String code;
    
    @ParentValue(name="name")
    private String name;
    
    @ChildValue(name="id")
    @ChildUnique
    private String typeId;
    
    @ChildValue(name="name")
    private String typeName;
    
    @SubChildValue(name="id")
    private String categoryId;
    
    @SubChildValue(name="name")
    private String categoryName;

    

    public Attribute(String id, String code, String name, String typeId,
            String typeName, String categoryId, String categoryName) {
        super();
        this.id = id;
        this.code = code;
        this.name = name;
        this.typeId = typeId;
        this.typeName = typeName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    
}
