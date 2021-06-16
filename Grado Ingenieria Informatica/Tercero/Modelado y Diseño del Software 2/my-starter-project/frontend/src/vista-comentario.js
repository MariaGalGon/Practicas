import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaComentario extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			margin: 15px;
        			border-radius: 25px;
        			background: #f5f5f5;
        			padding: 20px;
        			align-self: stretch;
                }
            </style>
<vaadin-vertical-layout style="height: 100%; margin: var(--lumo-space-s);" id="cuadro_comentario">
 <vaadin-horizontal-layout theme="spacing" id="cuadro_info_comentario" style="align-self: stretch; flex-grow: 0;">
  <img id="icono_perfil_comentario" style="align-self: center; padding: var(--lumo-space-s); border-radius: 20px;">
  <label id="nombre_usuario_comentario" style="align-self: center; padding: var(--lumo-space-s); font-weight: bold;"></label>
  <p id="contador_valoracion" style="align-self: center; padding: var(--lumo-space-xs);"></p>
  <p style="align-self: center; padding: var(--lumo-space-xs);">Estrellas</p>
 </vaadin-horizontal-layout>
 <p id="texto_comentario" style="flex-grow: 1; align-self: flex-start;"></p>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-comentario';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaComentario.is, VistaComentario);
