# -*- coding: utf-8 -*-  
import urllib2
import cookielib
import urllib
import re
import sys
# ����ϵͳ�ӿ�
def get(A,B,C):
	cookie = cookielib.CookieJar()    
	opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cookie))  
	#��ҪPOST������#  
	postdata=urllib.urlencode({    
		'account':A,    
		'pwd':B ,  
		'verifycode' :C,
	})    
	#�Զ���һ������#  
	req = urllib2.Request(    
		url = 'http://222.200.98.147/login!doLogin.action',    
		data = postdata  
	)  
	#���ʸ�����#  
	result = opener.open(req)  
	# print cookie
	# result2 = opener.open("http://222.200.98.147/login!welcome.action")
	#��ӡ���ص�����#  
	# for it in cookie:
		# it = it.value
	# print result.read().decode('utf-8')
	# print result.read()
	res=result.read()
	res=eval(res)
	result.close()
	if('y'==res['status']):
		f = open('/root/data.txt','a+')  
		f.writelines("account:"+A) 
		f.writelines("   ") 
		f.writelines("pwd:"+B) 	
		f.write('\n')	 		
		f.close() 
	# print res['status']
	return res['status']