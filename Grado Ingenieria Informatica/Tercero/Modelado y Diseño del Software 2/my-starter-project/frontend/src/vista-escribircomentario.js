import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaEscribircomentario extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: stretch;">
 <vaadin-text-area style="flex-grow: 1; padding: var(--lumo-space-s);" id="area_texto_comentario"></vaadin-text-area>
 <vaadin-horizontal-layout theme="spacing" style="flex-grow: 0;">
  <vaadin-button id="boton_publicar" style="flex-grow: 0; margin: var(--lumo-space-s);">
    Publicar 
  </vaadin-button>
  <vaadin-horizontal-layout theme="spacing" style="align-self: center; flex-grow: 1; justify-content: flex-end; margin: var(--lumo-space-s);" id="valoracion_comentario">
   <img id="estrella_1">
   <img id="estrella_2">
   <img id="estrella_3">
   <img id="estrella_4">
   <img id="estrella_5">
   <label id="contador_valoracion">2</label>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-escribircomentario';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaEscribircomentario.is, VistaEscribircomentario);
