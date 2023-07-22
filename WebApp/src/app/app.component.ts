import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  transactionForm = new FormGroup({
		productAmount : new FormGroup({
			soda: new FormControl(0),
			candyBar: new FormControl(0),
			chips: new FormControl(0),
    	}),
    	paymentForm : new FormGroup({
    		cardNumber: new FormControl(""),
    		expDate: new FormControl(""),
			cvc: new FormControl("")
    	})
	})

	onSubmit(): void{
		this.transactionForm.reset();
		console.log("Your order has been submitted")
	}
}
