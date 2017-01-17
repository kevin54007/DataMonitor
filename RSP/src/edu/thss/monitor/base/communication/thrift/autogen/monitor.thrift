namespace java edu.thss.monitor.base.communication.thrift.autogen   #�������/����ͨ�Ź���/thrift�Զ����ɴ������ڰ���

service ThriftResource {	#Storm��Ⱥ��Դ�ڵ��Thrift����
	binary thriftGetResource(1:string resourceType) 	#[��Դͬ��]:�����Դ
	void thriftReceiveChange(1:binary param)			#[��Դͬ��]:���ո���
	binary thriftRegister(1:binary param)			    #[��Դͬ��]:ע��ͬ���ͻ���
}

service ThriftProcess {		#Storm��Ⱥ����ڵ��Thrift����
	void thriftReceiveChange(1:binary param)			#[��Դͬ��]:���ո���
	void thriftSetLogLevel(1:string level)				#[ƽ̨����]:������־����
}

service ThriftPlatform {	#ƽ̨���Thrift����
	void thriftReceivePushData(1:binary param)			#������������
	void thriftReceiveLog(1:string source,2:string level,3:string content)	#������־��Ϣ��source(��Դ)��level(��־����)��content(��־����)
}