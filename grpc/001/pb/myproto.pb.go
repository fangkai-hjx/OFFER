//protoc --go_out=./ *.proto
//默认是版本2

// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.26.0-devel
// 	protoc        v3.15.0
// source: grpc/pb/myproto.proto

package pb

import (
	context "context"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
	protoreflect "google.golang.org/protobuf/reflect/protoreflect"
	protoimpl "google.golang.org/protobuf/runtime/protoimpl"
	reflect "reflect"
	sync "sync"
)

const (
	// Verify that this generated code is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(20 - protoimpl.MinVersion)
	// Verify that runtime/protoimpl is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(protoimpl.MaxVersion - 20)
)

type Week int32

const (
	Week_Monday   Week = 0 //枚举值必须从0开始
	Week_Turesday Week = 1
)

// Enum value maps for Week.
var (
	Week_name = map[int32]string{
		0: "Monday",
		1: "Turesday",
	}
	Week_value = map[string]int32{
		"Monday":   0,
		"Turesday": 1,
	}
)

func (x Week) Enum() *Week {
	p := new(Week)
	*p = x
	return p
}

func (x Week) String() string {
	return protoimpl.X.EnumStringOf(x.Descriptor(), protoreflect.EnumNumber(x))
}

func (Week) Descriptor() protoreflect.EnumDescriptor {
	return file_grpc_pb_myproto_proto_enumTypes[0].Descriptor()
}

func (Week) Type() protoreflect.EnumType {
	return &file_grpc_pb_myproto_proto_enumTypes[0]
}

func (x Week) Number() protoreflect.EnumNumber {
	return protoreflect.EnumNumber(x)
}

// Deprecated: Use Week.Descriptor instead.
func (Week) EnumDescriptor() ([]byte, []int) {
	return file_grpc_pb_myproto_proto_rawDescGZIP(), []int{0}
}

// 指定所在包名
// 定义一个消息体
type Student struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Age   int32   `protobuf:"varint,1,opt,name=age,proto3" json:"age,omitempty"` //可以不从1开始，但是不能重复
	Name  string  `protobuf:"bytes,2,opt,name=name,proto3" json:"name,omitempty"`
	P     *People `protobuf:"bytes,3,opt,name=p,proto3" json:"p,omitempty"`
	Score []int32 `protobuf:"varint,4,rep,packed,name=score,proto3" json:"score,omitempty"` //数组
	//枚举
	//联合体
	//
	// Types that are assignable to Data:
	//	*Student_Teacher
	//	*Student_Class
	Data isStudent_Data `protobuf_oneof:"data"`
}

func (x *Student) Reset() {
	*x = Student{}
	if protoimpl.UnsafeEnabled {
		mi := &file_grpc_pb_myproto_proto_msgTypes[0]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *Student) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*Student) ProtoMessage() {}

func (x *Student) ProtoReflect() protoreflect.Message {
	mi := &file_grpc_pb_myproto_proto_msgTypes[0]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use Student.ProtoReflect.Descriptor instead.
func (*Student) Descriptor() ([]byte, []int) {
	return file_grpc_pb_myproto_proto_rawDescGZIP(), []int{0}
}

func (x *Student) GetAge() int32 {
	if x != nil {
		return x.Age
	}
	return 0
}

func (x *Student) GetName() string {
	if x != nil {
		return x.Name
	}
	return ""
}

func (x *Student) GetP() *People {
	if x != nil {
		return x.P
	}
	return nil
}

func (x *Student) GetScore() []int32 {
	if x != nil {
		return x.Score
	}
	return nil
}

func (m *Student) GetData() isStudent_Data {
	if m != nil {
		return m.Data
	}
	return nil
}

func (x *Student) GetTeacher() string {
	if x, ok := x.GetData().(*Student_Teacher); ok {
		return x.Teacher
	}
	return ""
}

func (x *Student) GetClass() string {
	if x, ok := x.GetData().(*Student_Class); ok {
		return x.Class
	}
	return ""
}

type isStudent_Data interface {
	isStudent_Data()
}

type Student_Teacher struct {
	Teacher string `protobuf:"bytes,5,opt,name=teacher,proto3,oneof"`
}

type Student_Class struct {
	Class string `protobuf:"bytes,6,opt,name=class,proto3,oneof"`
}

func (*Student_Teacher) isStudent_Data() {}

func (*Student_Class) isStudent_Data() {}

// 消息体支持嵌套
type People struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Weight int32 `protobuf:"varint,1,opt,name=weight,proto3" json:"weight,omitempty"`
}

func (x *People) Reset() {
	*x = People{}
	if protoimpl.UnsafeEnabled {
		mi := &file_grpc_pb_myproto_proto_msgTypes[1]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *People) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*People) ProtoMessage() {}

func (x *People) ProtoReflect() protoreflect.Message {
	mi := &file_grpc_pb_myproto_proto_msgTypes[1]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use People.ProtoReflect.Descriptor instead.
func (*People) Descriptor() ([]byte, []int) {
	return file_grpc_pb_myproto_proto_rawDescGZIP(), []int{1}
}

func (x *People) GetWeight() int32 {
	if x != nil {
		return x.Weight
	}
	return 0
}

var File_grpc_pb_myproto_proto protoreflect.FileDescriptor

var file_grpc_pb_myproto_proto_rawDesc = []byte{
	0x0a, 0x15, 0x67, 0x72, 0x70, 0x63, 0x2f, 0x70, 0x62, 0x2f, 0x6d, 0x79, 0x70, 0x72, 0x6f, 0x74,
	0x6f, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x12, 0x02, 0x70, 0x62, 0x22, 0x9b, 0x01, 0x0a, 0x07,
	0x53, 0x74, 0x75, 0x64, 0x65, 0x6e, 0x74, 0x12, 0x10, 0x0a, 0x03, 0x61, 0x67, 0x65, 0x18, 0x01,
	0x20, 0x01, 0x28, 0x05, 0x52, 0x03, 0x61, 0x67, 0x65, 0x12, 0x12, 0x0a, 0x04, 0x6e, 0x61, 0x6d,
	0x65, 0x18, 0x02, 0x20, 0x01, 0x28, 0x09, 0x52, 0x04, 0x6e, 0x61, 0x6d, 0x65, 0x12, 0x18, 0x0a,
	0x01, 0x70, 0x18, 0x03, 0x20, 0x01, 0x28, 0x0b, 0x32, 0x0a, 0x2e, 0x70, 0x62, 0x2e, 0x50, 0x65,
	0x6f, 0x70, 0x6c, 0x65, 0x52, 0x01, 0x70, 0x12, 0x14, 0x0a, 0x05, 0x73, 0x63, 0x6f, 0x72, 0x65,
	0x18, 0x04, 0x20, 0x03, 0x28, 0x05, 0x52, 0x05, 0x73, 0x63, 0x6f, 0x72, 0x65, 0x12, 0x1a, 0x0a,
	0x07, 0x74, 0x65, 0x61, 0x63, 0x68, 0x65, 0x72, 0x18, 0x05, 0x20, 0x01, 0x28, 0x09, 0x48, 0x00,
	0x52, 0x07, 0x74, 0x65, 0x61, 0x63, 0x68, 0x65, 0x72, 0x12, 0x16, 0x0a, 0x05, 0x63, 0x6c, 0x61,
	0x73, 0x73, 0x18, 0x06, 0x20, 0x01, 0x28, 0x09, 0x48, 0x00, 0x52, 0x05, 0x63, 0x6c, 0x61, 0x73,
	0x73, 0x42, 0x06, 0x0a, 0x04, 0x64, 0x61, 0x74, 0x61, 0x22, 0x20, 0x0a, 0x06, 0x50, 0x65, 0x6f,
	0x70, 0x6c, 0x65, 0x12, 0x16, 0x0a, 0x06, 0x77, 0x65, 0x69, 0x67, 0x68, 0x74, 0x18, 0x01, 0x20,
	0x01, 0x28, 0x05, 0x52, 0x06, 0x77, 0x65, 0x69, 0x67, 0x68, 0x74, 0x2a, 0x20, 0x0a, 0x04, 0x57,
	0x65, 0x65, 0x6b, 0x12, 0x0a, 0x0a, 0x06, 0x4d, 0x6f, 0x6e, 0x64, 0x61, 0x79, 0x10, 0x00, 0x12,
	0x0c, 0x0a, 0x08, 0x54, 0x75, 0x72, 0x65, 0x73, 0x64, 0x61, 0x79, 0x10, 0x01, 0x32, 0x25, 0x0a,
	0x02, 0x66, 0x6b, 0x12, 0x1f, 0x0a, 0x03, 0x53, 0x61, 0x79, 0x12, 0x0b, 0x2e, 0x70, 0x62, 0x2e,
	0x53, 0x74, 0x75, 0x64, 0x65, 0x6e, 0x74, 0x1a, 0x0b, 0x2e, 0x70, 0x62, 0x2e, 0x53, 0x74, 0x75,
	0x64, 0x65, 0x6e, 0x74, 0x42, 0x0c, 0x5a, 0x0a, 0x2e, 0x2f, 0x67, 0x72, 0x70, 0x63, 0x2f, 0x70,
	0x62, 0x2f, 0x62, 0x06, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x33,
}

var (
	file_grpc_pb_myproto_proto_rawDescOnce sync.Once
	file_grpc_pb_myproto_proto_rawDescData = file_grpc_pb_myproto_proto_rawDesc
)

func file_grpc_pb_myproto_proto_rawDescGZIP() []byte {
	file_grpc_pb_myproto_proto_rawDescOnce.Do(func() {
		file_grpc_pb_myproto_proto_rawDescData = protoimpl.X.CompressGZIP(file_grpc_pb_myproto_proto_rawDescData)
	})
	return file_grpc_pb_myproto_proto_rawDescData
}

var file_grpc_pb_myproto_proto_enumTypes = make([]protoimpl.EnumInfo, 1)
var file_grpc_pb_myproto_proto_msgTypes = make([]protoimpl.MessageInfo, 2)
var file_grpc_pb_myproto_proto_goTypes = []interface{}{
	(Week)(0),       // 0: pb.Week
	(*Student)(nil), // 1: pb.Student
	(*People)(nil),  // 2: pb.People
}
var file_grpc_pb_myproto_proto_depIdxs = []int32{
	2, // 0: pb.Student.p:type_name -> pb.People
	1, // 1: pb.fk.Say:input_type -> pb.Student
	1, // 2: pb.fk.Say:output_type -> pb.Student
	2, // [2:3] is the sub-list for method output_type
	1, // [1:2] is the sub-list for method input_type
	1, // [1:1] is the sub-list for extension type_name
	1, // [1:1] is the sub-list for extension extendee
	0, // [0:1] is the sub-list for field type_name
}

func init() { file_grpc_pb_myproto_proto_init() }
func file_grpc_pb_myproto_proto_init() {
	if File_grpc_pb_myproto_proto != nil {
		return
	}
	if !protoimpl.UnsafeEnabled {
		file_grpc_pb_myproto_proto_msgTypes[0].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*Student); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_grpc_pb_myproto_proto_msgTypes[1].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*People); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
	}
	file_grpc_pb_myproto_proto_msgTypes[0].OneofWrappers = []interface{}{
		(*Student_Teacher)(nil),
		(*Student_Class)(nil),
	}
	type x struct{}
	out := protoimpl.TypeBuilder{
		File: protoimpl.DescBuilder{
			GoPackagePath: reflect.TypeOf(x{}).PkgPath(),
			RawDescriptor: file_grpc_pb_myproto_proto_rawDesc,
			NumEnums:      1,
			NumMessages:   2,
			NumExtensions: 0,
			NumServices:   1,
		},
		GoTypes:           file_grpc_pb_myproto_proto_goTypes,
		DependencyIndexes: file_grpc_pb_myproto_proto_depIdxs,
		EnumInfos:         file_grpc_pb_myproto_proto_enumTypes,
		MessageInfos:      file_grpc_pb_myproto_proto_msgTypes,
	}.Build()
	File_grpc_pb_myproto_proto = out.File
	file_grpc_pb_myproto_proto_rawDesc = nil
	file_grpc_pb_myproto_proto_goTypes = nil
	file_grpc_pb_myproto_proto_depIdxs = nil
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConnInterface

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion6

// FkClient is the client API for Fk service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://godoc.org/google.golang.org/grpc#ClientConn.NewStream.
type FkClient interface {
	Say(ctx context.Context, in *Student, opts ...grpc.CallOption) (*Student, error)
}

type fkClient struct {
	cc grpc.ClientConnInterface
}

func NewFkClient(cc grpc.ClientConnInterface) FkClient {
	return &fkClient{cc}
}

func (c *fkClient) Say(ctx context.Context, in *Student, opts ...grpc.CallOption) (*Student, error) {
	out := new(Student)
	err := c.cc.Invoke(ctx, "/pb.fk/Say", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// FkServer is the server API for Fk service.
type FkServer interface {
	Say(context.Context, *Student) (*Student, error)
}

// UnimplementedFkServer can be embedded to have forward compatible implementations.
type UnimplementedFkServer struct {
}

func (*UnimplementedFkServer) Say(context.Context, *Student) (*Student, error) {
	return nil, status.Errorf(codes.Unimplemented, "method Say not implemented")
}

func RegisterFkServer(s *grpc.Server, srv FkServer) {
	s.RegisterService(&_Fk_serviceDesc, srv)
}

func _Fk_Say_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(Student)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(FkServer).Say(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/pb.fk/Say",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(FkServer).Say(ctx, req.(*Student))
	}
	return interceptor(ctx, in, info, handler)
}

var _Fk_serviceDesc = grpc.ServiceDesc{
	ServiceName: "pb.fk",
	HandlerType: (*FkServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "Say",
			Handler:    _Fk_Say_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "grpc/pb/myproto.proto",
}
