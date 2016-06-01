package aisoai.screens.gamescreeens.titentities;

import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;

public class TITText extends Text
{
    private TITGameControl control;

    public TITText(float x,float y,Font font,String text,int textMax,TITGameControl iControl)
    {
        super(x,y,font,text,textMax,iControl.getActivity().getVertexBufferObjectManager());
        this.control=iControl;
    }

    public Font getTITFont()
    {
        return (Font) getFont();
    }

    public void changeText(String newText)
    {
        String oldText=getText().toString();
        float oldWidth=getTITFont().getStringWidth(oldText);
        float oldPostionX=getX();
        float centerX=oldPostionX+oldWidth/2;

        float newWidth=getTITFont().getStringWidth(newText);

        float newPostionX=centerX-newWidth/2;
        float postionY=getY();

        setPosition(newPostionX,postionY);
        setText(newText);
    }
}
