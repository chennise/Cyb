import java.util.List;
import java.util.Scanner;



public class views {
	private static final String CONTEXT="�gӭ��¼ѧ���ɼ�ϵͳ�� \n"+
    "[query/q]����ԃȫ��ѧ����Ϣ\n"+
	"[get/g]:�鿴ĳ��ѧ����Ϣ\n"+
    "[add/a]:���ѧ����Ϣ\n"+
	"[update/u]:����ѧ����Ϣ\n"+
	"[show/s]:���ܳɼ��Ӹߵ������ѧ����Ϣ\n"+
    "[delete/d]:�h��ѧ����Ϣ\n"+
    "[exit/e]:�˳�ѧ���ɼ�ϵͳ\n";
    public static final String cquery="query";
    public static final String cget="get";
    public static final String cadd="add";
    public static final String cupdate="update";
    public static final String cdelete="delete";
    public static final String cexit="exit";
    public static final String cshow="show";
    

	public static void main(String[] args) {
	    System.out.println(CONTEXT);
	    Scanner scan=new Scanner(System.in);
	    String prenious=null,pre=null,pp=null,ppp=null,pppp=null;
	    Integer step=1,step1=1,step2=1,step3=1;
	    Students goddness=new Students();
	    action act=new action();
        while(scan.hasNext()){
        	String in=scan.next().toString();
        	if(cexit.equals(in)){
        		System.out.println("���ѽ��ɹ��˳�ѧ���ɼ�ϵͳ");
        		break;
        	}else if(cquery.equals(in)||cquery.equals(pre)){
        		try {
					List<Students> list=act.query();
					for(Students go :list){
						 System.out.println(go.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
					 System.out.println("��ԃ�e�`");}
				}else if(cshow.equals(in)||cshow.equals(pppp)){
	        		try {
	        			List<Students> list=act.show();
	        			 System.out.println("���ɼ��Ӹߵ�������");
						for(Students go :list){
							
							 System.out.println(go.toString());}
						
					} catch (Exception e) {
						e.printStackTrace();
						 System.out.println("��ԃ�e�`");
					}
        	}else if(cget.equals(in)||cget.equals(pre)){
            		try {
            			if(step1==1){
            			System.out.println("������Ҫ��ѯѧ����ѧ��"); 
            			step1++;}
            			else if(step1==2){
            			goddness =act.get(Integer.valueOf(in));
      
            			System.out.println(goddness.toString());}
    					
    				} catch (Exception e) {
    					e.printStackTrace();
    					 System.out.println("��ԃ�e�`");
    				}
            		if(cdelete.equals(pre)){
            	 		step1++;
            	 	}
        	}else if(cdelete.equals(in)||cdelete.equals(pp)){
     		   pp=cdelete;
       		try {
       			if(step2==1){
       			System.out.println("������Ҫɾ��ѧ����ѧ��"); 
       			}
       			else if(step2==2){
       			act.del(Integer.valueOf(in));
       			System.out.println("ɾ���ɹ�");}
					
				} catch (Exception e) {
					e.printStackTrace();
					 System.out.println("ɾ��ʧ��");
				}
       		if(cdelete.equals(pp)){
    	 		step2++;
    	 	}
        	}else if(cupdate.equals(in)||cupdate.equals(ppp)){
      		   ppp=cupdate;
      		 if(1==step3){
     	 		System.out.println("Ոݔ��ѧ��ѧ�ţ�");
     	 	}else if(2==step3){
     	 		goddness.setSid(Integer.valueOf(in));
     	 		System.out.println("Ոݔ��ѧ��������");
     	 	}else if(3==step3){
     	 		goddness.setSname(in);
     	 		System.out.println("Ոݔ�����ݽṹ�ɼ���");
     	 	}else if(4==step3){
     	 		goddness.setScore1(Integer.valueOf(in));
					System.out.println("Ոݔ�����ϵͳ�ɼ���");
					
     	 	}else if(5==step3){
     	 		goddness.setScore2(Integer.valueOf(in));
     	 		System.out.println("Ոݔ����ֵ����ɼ���");
     	 		
     	 	
     	 	}else if(6==step3){     	 		
     	 		goddness.setScore3(Integer.valueOf(in));
     	 		int a=Integer.valueOf(goddness.getScore1())+Integer.valueOf(goddness.getScore2())+Integer.valueOf(goddness.getScore3());
     	 		goddness.setScore4(a);
     	 		try {
						act.edit(goddness);
						System.out.println("�޸�ѧ����Ϣ�ɹ���");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("�޸�ѧ����Ϣʧ�ܣ�");
						
					}
     	 	}
     	 	if(cupdate.equals(ppp)){
     	 		step3++;
     	 	}
        	}else if(cadd.equals(in)||cadd.equals(prenious)){
        	 	prenious=cadd;
        		//����Ů��
        	 
        		if(1==step){
        	 		System.out.println("Ոݔ��ѧ��ѧ�ţ�");
        	 	}else if(2==step){
        	 		goddness.setSid(Integer.valueOf(in));
        	 		System.out.println("Ոݔ��ѧ��������");
        	 	}else if(3==step){
        	 		goddness.setSname(in);
        	 		System.out.println("Ոݔ�����ݽṹ�ɼ���");
        	 	}else if(4==step){
        	 		goddness.setScore1(Integer.valueOf(in));
					System.out.println("Ոݔ�����ϵͳ�ɼ���");
					
        	 	}else if(5==step){
        	 		goddness.setScore2(Integer.valueOf(in));
        	 		System.out.println("Ոݔ����ֵ����ɼ���");
        	 		
        	 	
        	 	}else if(6==step){     	 		
        	 		goddness.setScore3(Integer.valueOf(in));
        	 		int a=Integer.valueOf(goddness.getScore1())+Integer.valueOf(goddness.getScore2())+Integer.valueOf(goddness.getScore3());
        	 		goddness.setScore4(a);
        	 		try {
						act.add(goddness);
						System.out.println("����ѧ���ɹ���");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("����ѧ��ʧ����");
						
					}
        	 	}
        	 	if(cadd.equals(prenious)){
        	 		step++;
        	 	}
        		
        		
        	}else{
        	System.out.println("��ݔ���ֵ�飺"+in);
        	}
        }
	}

}
