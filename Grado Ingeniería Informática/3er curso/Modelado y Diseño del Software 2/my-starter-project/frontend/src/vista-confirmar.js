import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';

class VistaConfirmar extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        		position: absolute;
        		background-color: white;
        		width: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout">
 <img id="foto" style="align-self: center;">
 <p id="texto" style="align-self: center;">Sentimos que nos dejes. Aún puedes seguir navegando por nuestra página</p>
 <vaadin-button id="boton_productos" style="align-self: center;">
   Ver los productos más populares 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-confirmar';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaConfirmar.is, VistaConfirmar);
