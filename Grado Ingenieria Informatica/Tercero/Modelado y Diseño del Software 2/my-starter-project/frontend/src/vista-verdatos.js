import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';

class VistaVerdatos extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                     display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="ver_datos">
 <vaadin-horizontal-layout theme="spacing" id="cuadro_nombre_apellidos" style="align-self: stretch;">
  <vaadin-text-field label="Nombre" id="nombre" style="flex-grow: 1;"></vaadin-text-field>
  <vaadin-text-field label="Apellidos" id="apellidos" style="flex-grow: 1;"></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-text-field label="Nombre y Apellidos" id="nombre_apellidos" style="align-self: stretch;"></vaadin-text-field>
 <vaadin-text-field label="Correo" id="correo" style="align-self: stretch;"></vaadin-text-field>
 <vaadin-password-field label="Contraseña nueva" placeholder="" value="secret1" id="contrasenia" style="align-self: stretch;" has-value></vaadin-password-field>
 <vaadin-text-field label="Dirección de envío" id="direccion_envio" style="align-self: stretch;"></vaadin-text-field>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: stretch;">
  <vaadin-text-field label="Número de cuenta" id="numero_cuenta" style="flex-grow: 1;"></vaadin-text-field>
  <vaadin-text-field label="CVV" id="cvv"></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-text-field label="ID" placeholder="Placeholder" id="id_repartidor" style="align-self: stretch;" value="7596592" tabindex="" has-value readonly>
   njk 
 </vaadin-text-field>
 <vaadin-button id="boton_guardar" style="margin-top: var(--lumo-space-l);">
   Guardar 
 </vaadin-button>
 <vaadin-button id="boton_cerrar_sesion">
   Cerrar Sesión 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-verdatos';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVerdatos.is, VistaVerdatos);
