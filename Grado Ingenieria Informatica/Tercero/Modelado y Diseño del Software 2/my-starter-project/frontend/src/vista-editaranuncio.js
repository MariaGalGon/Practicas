import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-upload/src/vaadin-upload-file.js';
import '@vaadin/vaadin-upload/src/vaadin-upload.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaEditaranuncio extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%;" theme="spacing-s" id="vaadinVerticalLayout">
 <vaadin-text-field label="Nombre" id="nombre" name="nombre_anuncio"></vaadin-text-field>
 <vaadin-text-field label="Enlace" style="align-self: stretch;" id="enlace_anuncio"></vaadin-text-field>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout">
  <vaadin-text-field label="Altura" id="altura_anuncio"></vaadin-text-field>
  <vaadin-text-field label="Anchura" id="anchura_anuncio"></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="hueco_upload" style="align-self: stretch;"></vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1" style="margin-top: var(--lumo-space-xl);">
  <vaadin-button id="boton_guardar_anuncio">
    Guardar 
  </vaadin-button>
  <vaadin-button style="align-self: flex-start; flex-grow: 0;" id="boton_eliminar_anuncio">
    Eliminar 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-editaranuncio';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaEditaranuncio.is, VistaEditaranuncio);
