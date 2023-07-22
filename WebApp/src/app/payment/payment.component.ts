import { Component, Input } from '@angular/core';
import { FormGroup, FormGroupDirective } from '@angular/forms';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  @Input() formGroupName: string = "";
  public paymentForm: FormGroup = new FormGroup({});
  constructor(private rootFormGroup: FormGroupDirective) {}
  
  ngOnInit(): void {
    this.paymentForm = this.rootFormGroup.control.get(this.formGroupName) as FormGroup;
  }
}
