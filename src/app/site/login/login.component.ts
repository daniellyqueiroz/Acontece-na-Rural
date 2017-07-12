import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	public formLogin: FormGroup;

  constructor(private fb: FormBuilder) {
		this.createForm();
	 }

	doLogin(event) {
    console.log(event);
    console.log(this.formLogin.value);
  }

	createForm(){
		this.formLogin = this.fb.group({
    usuario: ["", Validators.required],
    senha: ["", Validators.required]
  });
	}
  ngOnInit() {
		
  }

}
