import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';

class VistaIniciarsesion extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                   display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
        			margin: 0px;
border-spacing: 0;
border-collapse: collapse;
                }
            </style>
<vaadin-vertical-layout id="web" style="align-items: center; align-self: stretch; width: 100%;padding: 0px;" theme="XS">
 <h1 id="web_titulo">Iniciar Sesión</h1>
 <vaadin-text-field label="Correo Electrónico" id="web_correo"></vaadin-text-field>
 <vaadin-password-field label="Contraseña" value="secret1" id="contrasenia" has-value></vaadin-password-field>
 <a href="#" id="web_enlace_recuperar_contrasenia">Recuperar Contraseña</a>
 <vaadin-button id="web_boton_iniciar_sesion" style="margin: var(--lumo-space-s); margin-top: var(--lumo-space-m);">
   Iniciar Sesión 
 </vaadin-button>
 <vaadin-button id="web_boton_crear_cuenta" style="margin: var(--lumo-space-s);">
   Crear una cuenta 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-iniciarsesion';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaIniciarsesion.is, VistaIniciarsesion);
