// Date: 23.12.2015 23:32:22
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.hbm.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ModelGasMask extends ModelBiped
{
  //fields
    ModelRenderer mask;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
  
  public ModelGasMask()
  {
    textureWidth = 64;
    textureHeight = 32;
      
      bipedHead = new ModelRenderer(this, 0, 0);
      bipedHead.addBox(0F - 4, 0F - 8 + 0.5F, 0F - 4, 8, 8, 3);
      
      bipedHead.setTextureOffset(22, 0);
      bipedHead.addBox(1F - 4, 3F - 8 + 0.5F, -0.5333334F - 4, 2, 2, 1);

      bipedHead.setTextureOffset(22, 0);
      bipedHead.addBox(5F - 4, 3F - 8 + 0.5F, -0.5F - 4, 2, 2, 1);
      
      bipedHead.setTextureOffset(0, 22);
      bipedHead.addBox(0F - 4, 3F - 8 + 0.5F, 3F - 4, 8, 1, 5);

      mask = bipedHeadwear;
      mask.setTextureOffset(0, 11);
      mask.addBox(0 - 1, 0 + 2, 0F - 4, 2, 2, 2);
      
      mask.setTextureOffset(0, 15);
      mask.addBox(0 - 1.5F, 2 + 0.5F - 0.5F + 2, -0.5F - 4, 3, 4, 3);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
	  EntityPlayer player = (EntityPlayer)entity;
	  if(player.isSneaking())
	  {
		  this.isSneak = true;
	  } else {
		  this.isSneak = false;
	  }
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.mask.rotationPointX = bipedHead.rotationPointX;
    this.mask.rotationPointY = bipedHead.rotationPointY;
    this.mask.rotateAngleX = bipedHead.rotateAngleX - 45;
  }
  @Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    GL11.glPushMatrix();
    GL11.glScalef(1.2F, 1.2F, 1.2F);
    bipedHead.render(par7);
    mask.render(par7);
    GL11.glPopMatrix();
  }

}
