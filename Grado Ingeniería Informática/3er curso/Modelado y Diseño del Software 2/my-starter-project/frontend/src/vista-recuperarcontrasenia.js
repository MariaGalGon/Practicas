import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaRecuperarcontrasenia extends PolymerElement {

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
<vaadin-vertical-layout style="align-items: center;">
 <h1 id="titulo" style="margin-bottom: var(--lumo-space-xs);">Recuperar Contraseña</h1>
 <p id="informacion" style="margin-top: var(--lumo-space-xs);">Se te enviará un enlace para restablecer la contraseña</p>
 <vaadin-text-field label="Correo Electrónico" id="correo"></vaadin-text-field>
 <vaadin-button id="boton_recuperar" style="margin: var(--lumo-space-m);">
  Recuperar Contraseña
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-recuperarcontrasenia';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaRecuperarcontrasenia.is, VistaRecuperarcontrasenia);
