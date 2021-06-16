import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaCrearcuenta extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			position: absolute;
        			background-color: white;
                }
            </style>
<vaadin-vertical-layout style="align-items: center;" id="verticalLayout">
 <h1 id="titulo">Crear Cuenta</h1>
 <vaadin-horizontal-layout theme="spacing" style="align-self: center;">
  <vaadin-vertical-layout theme="spacing">
   <vaadin-text-field label="Nombre de usuario" id="usuario"></vaadin-text-field>
   <vaadin-text-field label="Correo Electrónico" id="correo"></vaadin-text-field>
   <vaadin-password-field label="Contraseña" value="secret1" id="contrasenia" has-value></vaadin-password-field>
   <vaadin-password-field label="Confirmar contraseña" value="secret1" has-value id="confirma_cont"></vaadin-password-field>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing">
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-vertical-layout theme="spacing">
     <vaadin-text-field label="Nombre" id="nombre"></vaadin-text-field>
     <vaadin-text-field label="Apellidos" id="apellidos"></vaadin-text-field>
    </vaadin-vertical-layout>
    <vaadin-vertical-layout theme="spacing" id="hueco_upload">
     <img id="foto">
     <vaadin-horizontal-layout theme="spacing" id="hueco"></vaadin-horizontal-layout>
    </vaadin-vertical-layout>
   </vaadin-horizontal-layout>
   <vaadin-text-field label="Dirección de envío" id="direccion" style="align-self: stretch;"></vaadin-text-field>
   <vaadin-text-field label="Número de cuenta" id="cuenta" style="align-self: stretch;"></vaadin-text-field>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-button id="boton_crear_cuenta">
   Crear cuenta 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-crearcuenta';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCrearcuenta.is, VistaCrearcuenta);
