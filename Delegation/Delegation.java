package project_2;

public class Delegation {
	public static void main(String args[]) {
		C c = new C();
		System.out.println(c.r());
		D d = new D();
		System.out.println(d.r());
		
		C2 c2 = new C2();
		System.out.println(c2.r());
		D2 d2 = new D2();
		System.out.println(d2.r());	
	}
}

 abstract class A {
	int a1 = 1;
	int a2 = 2;

	public int f() {
		return a1 + p(100) + q(100);
	}

    protected abstract int p(int m);
    protected abstract int q(int m);
 }
 
 
 class B extends A {
	int b1 = 10;
	int b2 = 20;

	public int g() {
		return f() + this.q(200);
	}

	public int p(int m) {
		return m + b1;
	}

	public int q(int m) {
		return m + b2;
	}
}
 

class C extends B {
	int c1 = 100;
	int c2 = 200;

	public int r() {
		return f() + g() + c1;
	}
	
	public int p(int m) {
		return super.p(m) + super.q(m) + c2;
	}
	
	public int q(int m) {
		return m + a2 + b2 + c2;
	}
}

class D extends B {
	int d1 = 300;
	int d2 = 400;
	
	public int p(int m) {
		return m + a1 + b1 + d1;
		
	}
	public int r() {
		return f() + g() + d2;
	}

}

// Simulating Inheritance by Delegation

interface IA{
	int f();
	int p(int m);
	int q(int m);
	int getA1();
	int getA2();
}

interface IB extends IA{
	int g();
	int p(int m);
	int q(int m);
	int getB1();
	int getB2();
}

interface IC extends IB{
	int r();
	int p(int m);
	int q(int m);
}

interface ID extends IB{
	int p(int m);
	int r();
}

class A2 implements IA{
	
	int a1 = 1;
	int a2 = 2;
	
	public int getA1() {
		return a1;
	}
	
	public int getA2() {
		return a2;
	}

	IA this2;

	public A2(IA p){
		this2 = p;
	}

	public int f() {
		return a1 + p(100) + q(100);
	}

	public int p(int m){
		return this2.p(m);
	}

	public int q(int m){
		return this2.q(m);
	}
}

class B2 implements IB{

	int b1 = 10;
	int b2 = 20;
	
	public int getB1() {
		return b1;
	}
	
	public int getB2() {
		return b2;
	}

	IB this2;
	IA super2;
//	A2 a;

	public B2(IB b){
		this2 = b;
		super2 = new A2(this);
	}

	public int f() {
		return getA1() + p(100) + q(100);
	}

	public int g() {
		return f() + this.q(200);
	}

	public int p(int m) {
		return m + b1;
	}

	public int q(int m) {
		return m + b2;
	}

	@Override
	public int getA1() {
		// TODO Auto-generated method stub
		return super2.getA1();
	}

	@Override
	public int getA2() {
		// TODO Auto-generated method stub
		return super2.getA2();
	}
}

class C2 implements IC{
	
	int c1 = 100;
	int c2 = 200;
	
	IB super2;
	
//	public C2(IC c){
//		super2 = new B2(this);
//	}
	
	public C2(){
//		b = new B2(this);
		super2 = new B2(this);
	}
	
	public int f() {
		return getA1() + p(100) + q(100);
	}

	public int g() {
		return f() + this.q(200);
	}
	
	public int r() {
		return f() + g() + c1;
		}
	
	public int p(int m) {
//		return super.p(m) + super.q(m) + c2;
		return super2.p(m)+super2.q(m)+c2;
	}
	
	public int q(int m) {
		return m + getA2() + getB2() + c2;
	}

	@Override
	public int getB1() {
		// TODO Auto-generated method stub
		return super2.getB1();
	}

	@Override
	public int getB2() {
		// TODO Auto-generated method stub
		return super2.getB2();
	}

	@Override
	public int getA1() {
		// TODO Auto-generated method stub
		return super2.getA1();
	}

	@Override
	public int getA2() {
		// TODO Auto-generated method stub
		return super2.getA2();
	}
	
}

class D2 implements ID{
	
	int d1 = 300;
	int d2 = 400;
	
	IB super2;
	
	public D2(){
		super2 = new B2(this);
	}
	
	public int f() {
		return getA1() + p(100) + q(100);
	}
	
	public int g() {
		return f() + this.q(200);
	}
	
	public int p(int m) {
		return m + getA1() + getB1() + d1;
		
	}
	public int r() {
		return f() + g() + d2;
	}
	
	public int q(int m) {
		return m + getB2();
	}

	@Override
	public int getB1() {
		// TODO Auto-generated method stub
		return super2.getB1();
	}

	@Override
	public int getB2() {
		// TODO Auto-generated method stub
		return super2.getB2();
	}

	@Override
	public int getA1() {
		// TODO Auto-generated method stub
		return super2.getA1();
	}

	@Override
	public int getA2() {
		// TODO Auto-generated method stub
		return super2.getA2();
	}
}