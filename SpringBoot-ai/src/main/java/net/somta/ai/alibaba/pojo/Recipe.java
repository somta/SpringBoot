package net.somta.ai.alibaba.pojo;

/**
 * 菜谱
 */
public class Recipe {
    /**
     * 菜谱名称
     */
    private String name;
    /**
     * 食材
     */
    private String ingredients;

    /**
     * 步骤
     */
    private String steps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
