public class Workshop
{
    protected Vehicle[] type;
    protected int capacity;

    public Workshop(Vehicle[] type, int capacity)
    {
        this.type = type;
        this.capacity = capacity;
    }



    public void load(Vehicle fordon)
    {
        for (int i = 0; i < type.length; i++)
        {
//            if (fordon.getClass() == type[i])
            {

            }
        }
    }


    public void unLoad(Vehicle fordon)
    {

    }
}

